-- 코드를 작성해주세요
SELECT COUNT(*) AS COUNT
FROM ECOLI_DATA
# WHERE GENOTYPE = 1 OR GENOTYPE = 3
# WHERE (GENOTYPE != 2) AND (GENOTYPE = 1 OR 3)
WHERE SUBSTRING(BIN(GENOTYPE), -2, 1) != '1'
AND (SUBSTRING(BIN(GENOTYPE), -1, 1) = '1' OR SUBSTRING(BIN(GENOTYPE), -3, 1) = '1');


# SELECT COUNT(*) AS COUNT
# FROM ECOLI_DATA
# WHERE (GENOTYPE & 2) = 0
#   AND ((GENOTYPE & 1) > 0 OR (GENOTYPE & 4) > 0)