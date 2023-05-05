use appshop;

SELECT p.image,
 p.name,
 p.price,
 SUM(cd.quantity) as quantity,
 SUM(p.price) AS total_amount
FROM cart c
JOIN account a ON c.account_id = a.account_id
JOIN cart_detail cd ON cd.cart_id = c.id
JOIN product p ON cd.product_id = p.id
WHERE a.account_id = 2
GROUP BY p.image, p.name, p.price, cd.quantity;

select c.id from account a join cart c
on a.account_id = 2;