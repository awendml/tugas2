WITH RECURSIVE tbl_factorial (n, factorial)
AS (
    SELECT 1 as n, 6 as factorial
union all
    SELECT n+1, factorial*n FROM tbl_factorial where n < 6
)
SELECT * FROM tbl_factorial;