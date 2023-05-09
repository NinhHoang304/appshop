use appshop;

SELECT p.image, cd.id, p.name, p.price, SUM(cd.quantity) as quantity, SUM(p.price * cd.quantity) AS total_amount 
FROM cart c 
JOIN account a ON c.account_id = a.account_id 
JOIN cart_detail cd ON cd.cart_id = c.id 
JOIN product p ON cd.product_id = p.id 
WHERE a.account_id = 2 and cd.deleted = 0
GROUP BY p.image, cd.id, p.name, p.price, cd.quantity 
LIMIT 0, 300;

select c.id from account a join cart c
on a.account_id = 2;

select * from cart_detail where id = 1;

SELECT c.id as cartId FROM account a join cart c on a.account_id = c.account_id where c.account_id = 2;

update cart_detail set deleted = 0 where id = 3;