 SELECT * FROM(SELECT order_num, rownum as num FROM (SELECT DISTINCT order_num FROM bespeak WHERE order_state IN(7, 8, 9) ORDER BY order_num DESC)) WHERE num >= X_16030521653400 AND num <= X_16030521653401