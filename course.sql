SELECT * FROM public.course
ORDER BY course_id ASC 

DROP PROCEDURE IF EXISTS insert_all_data;

CREATE OR REPLACE PROCEDURE insert_all_data(
    p_student_id INT,
    p_student_name VARCHAR,
    p_email VARCHAR,
    p_dob VARCHAR,

    p_course_id INT,
    p_course_name VARCHAR,
    p_credit DOUBLE PRECISION, 

    p_enroll_id INT,
    p_grade VARCHAR
)
LANGUAGE plpgsql
AS $$
BEGIN

    INSERT INTO student(student_id, student_name, student_email, dob)
    VALUES (p_student_id, p_student_name, p_email, p_dob);

    INSERT INTO course(course_id, course_name, credits)
    VALUES (p_course_id, p_course_name, p_credit);

    INSERT INTO enrolment(enrolment_id, student_id, course_id, grade)
    VALUES (p_enroll_id, p_student_id, p_course_id, p_grade);

END;
$$;