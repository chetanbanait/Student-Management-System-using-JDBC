SELECT * FROM public.student
ORDER BY student_id ASC 

CREATE OR REPLACE FUNCTION get_student_grade(p_student_id INT)
RETURNS TABLE (
    student_id INT,
    student_name VARCHAR,
    grade VARCHAR
)
AS $$
BEGIN
    RETURN QUERY
    SELECT s.student_id, s.student_name, e.grade
    FROM student s
    JOIN enrolment e ON s.student_id = e.student_id
    WHERE s.student_id = p_student_id;
END;
$$ LANGUAGE plpgsql;
