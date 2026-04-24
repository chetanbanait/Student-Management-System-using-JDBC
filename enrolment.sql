SELECT * FROM public.enrolment
ORDER BY enrolment_id ASC 

CREATE OR REPLACE PROCEDURE insert_all_data(
    -- student
    p_student_id INT,
    p_student_name TEXT,
    p_email TEXT,
    p_dob TEXT,

    -- course
    p_course_id INT,
    p_course_name TEXT,
    p_credit NUMERIC,

    -- enrollment
    p_enroll_id INT,
    p_grade TEXT
)
LANGUAGE plpgsql
AS $$
BEGIN
    -- 🔹 Validation
    IF EXISTS (SELECT 1 FROM student WHERE student_id = p_student_id) THEN
        RAISE EXCEPTION 'Student already exists';
    END IF;

    IF EXISTS (SELECT 1 FROM course WHERE course_id = p_course_id) THEN
        RAISE EXCEPTION 'Course already exists';
    END IF;

    -- 🔹 Insert Student
    INSERT INTO student(student_id, student_name, email, dob)
    VALUES (p_student_id, p_student_name, p_email, p_dob);

    -- 🔹 Insert Course
    INSERT INTO course(course_id, course_name, credit)
    VALUES (p_course_id, p_course_name, p_credit);

    -- 🔹 Insert Enrollment
    INSERT INTO enrolment(enrollment_id, student_id, course_id, grade)
    VALUES (p_enroll_id, p_student_id, p_course_id, p_grade);

    RAISE NOTICE 'All records inserted successfully';

EXCEPTION
    WHEN OTHERS THEN
        RAISE NOTICE 'Error occurred. Transaction rolled back.';
        RAISE;
END;
$$;
