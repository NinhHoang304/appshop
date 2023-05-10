use appshop;

insert into category (id, name)
values
(1, 'IPhone'),
(2, 'IPad'),
(3, 'IMac'),
(4, 'Apple Watch'),
(5, 'AirPod'),
(6, 'Accessories');

insert into product (id, code, name, price, quantity, brand, description, image, deleted, category_id)
values
(1,'SP-01','IPhone 14 Pro Max', 1190, 5, 'Apple', 'Phone 14 Pro Max. Capture impressive details with the 48MP Main Camera. Experience iPhone in a whole new way with Dynamic Island and the Always On display.'
,'https://shopdunk.com/images/thumbs/0009074_iphone-14-pro-1tb_240.png', 0, 1),
(2,'SP-02','IPhone 14 Pro', 1090, 5, 'Apple', 'Phone 14 Pro. Capture impressive details with the 48MP Main Camera. Experience iPhone in a whole new way with Dynamic Island and the Always On display.'
,'https://shopdunk.com/images/thumbs/0008744_iphone-14-pro-128gb_550.png', 0, 1),
(3,'SP-03','IPhone 14', 899, 5, 'Apple', 'Phone 14. Capture impressive details with the 48MP Main Camera. Experience iPhone in a whole new way with Dynamic Island and the Always On display.'
,'https://shopdunk.com/images/thumbs/0009200_iphone-14-128gb_550.png', 0, 1),
(4,'SP-04','IPhone 13 Plus', 998, 5, 'Apple', 'Phone 13 Plus. Capture impressive details with the 48MP Main Camera. Experience iPhone in a whole new way with Dynamic Island and the Always On display.'
,'https://shopdunk.com/images/thumbs/0009532_iphone-14-plus-128gb_550.png', 0, 1),
(5,'SP-05','iPad gen 9 10.2 inch', 699, 5, 'Apple', 'iPad Gen 9 (2021) Mạnh mẽ. Dễ sử dụng. Đa năng. Học sinh thích học với iPad mới. Với chip A13 Bionic mạnh mẽ, thời lượng pin bền bỉ cả ngày, màn hình Retina 10.2 inch tuyệt đẹp'
,'https://shopdunk.com/images/thumbs/0006300_silver_550.webp', 0, 2),
(6,'SP-06','iPad Pro M2 11 inch', 1029, 5, 'Apple', 'iPad Pro M1. With impressive performance, super-fast wireless connections, and the next-generation Apple Pencil experience. Along with powerful new features for productivity and collaboration in iPadOS 16. iPad Pro delivers the ultimate iPad experience.'
,'https://shopdunk.com/images/thumbs/0007083_ipad-pro-m2-11-inch-wifi-128gb_550.webp', 0, 2),
(7,'SP-07','iPad Pro M2 12.9 inch', 1299, 5, 'Apple', 'iPad Pro M2. With impressive performance, super-fast wireless connections, and the next-generation Apple Pencil experience. Along with powerful new features for productivity and collaboration in iPadOS 16. iPad Pro delivers the ultimate iPad experience.'
,'https://shopdunk.com/images/thumbs/0007313_ipad-pro-m2-129-inch-wifi-128gb_550.webp', 0, 2),
(8,'SP-08','iPad Gen 10th 10.9 inch', 799, 5, 'Apple', 'Redesigned to be more colorful and versatile than ever. With an all-screen design, 10.9-inch Liquid Retina display1 and gorgeous four colors. iPad offers a powerful way to create, stay connected, and get things done.'
,'https://shopdunk.com/images/thumbs/0009726_ipad-gen-10th-109-inch-wi-fi-64gb_550.webp', 0, 2),
(9,'SP-09','MacBook Pro M1 2020', 1899, 5, 'Apple', 'Redesigned to be more colorful and versatile than ever. Featuring an all-screen design, 10.9-inch Liquid Retina display1 and gorgeous four colors. iPad offers a powerful way to create, stay connected, and get things done.MacBook Pro M1 A dramatic change thanks to the Apple M1 chip, with up to 2.8x more processing power, and faster graphics processing. graphics 5x faster. And up to 20 hours of battery life.'
,'https://shopdunk.com/images/thumbs/0001262_silver_550.webp', 0, 3),
(10,'SP-010','MacBook Air M2 2022', 2059, 5, 'Apple', 'Redesigned to be more colorful and versatile than ever. Featuring an all-screen design, 10.9-inch Liquid Retina display1 and gorgeous four colors. iPad offers a powerful way to create, stay connected, and get things done.MacBook Pro M1 A dramatic change thanks to the Apple M1 chip, with up to 2.8x more processing power, and faster graphics processing. graphics 5x faster. And up to 20 hours of battery life.'
,'https://shopdunk.com/images/thumbs/0008514_macbook-air-136-inch-m2-chip-with-8-core-cpu-and-8-core-gpu-256gb_550.png', 0, 3),
(11,'SP-11','Apple Watch Ultra LTE 49mm', 1019, 5, 'Apple', 'Specialized features and sensors, plus three new bands designed for exploration, adventure, and endurance activities'
,'https://shopdunk.com/images/thumbs/0008914_watch-ultra-gps-cellular-49mm-titanium-case-with-alpine-loop-small_550.png', 0, 4),
(12,'SP-12','Apple Watch Series 8 41mm', 699, 5, 'Apple', 'Apple Watch Series 8 has state-of-the-art sensors and health apps, so you can take an electrocardiogram (ECG), which measures heart rate and blood oxygen levels.'
,'https://shopdunk.com/images/thumbs/0002083_product-red_550.png', 0, 4),
(13,'SP-13','AirPods 2', 269, 5, 'Apple', 'AirPods gen 2 with Charging Case (normal charging box). AirPods 2 is a combination of iconic design and high-quality sound. Delivering a unique wireless headphone experience and a comfortable, all-day fit for everyone.'
,'https://shopdunk.com/images/thumbs/0006052_airpods-2_550.jpeg', 0, 5),
(14,'SP-14','AirPods Max', 989, 5, 'Apple', 'AirPods Max redefines over-ear headphones. Apple-designed speaker drivers for high-fidelity sound. Every detail, from the bezel to the ear cushions, is designed for an incredible fit.'
,'https://shopdunk.com/images/thumbs/0012010_sky-blue_550.webp', 0, 5),
(15,'SP-15','Magic Mouse 2', 169, 5, 'Apple', 'New lightweight, compact design, using charging via lightning cable instead of traditional batteries. Just need to charge 2 hours can use continuously for up to 1 month.'
,'https://shopdunk.com/images/thumbs/0001442_white_550.jpeg', 0, 6),
(16,'SP-16','Pencil 2', 319, 5, 'Apple', 'Apple Pencil 2 (2nd generation) Magnetic mount. Wireless charging. Easy to use like never before.'
,'https://shopdunk.com/images/thumbs/0001417_pencil-2_550.png', 0, 6);

insert into role (id, name)
values
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');

insert into account (account_id, address, date_of_birth, deleted, email, gender, name, password, phone)
values
(1, '123 Hung Vuong', '1996-04-04', 0, 'hoang@gmail.com', 0, 'HuuHoang', '$2a$12$/2724fWWWxRUhObLpNnvi.6QtqgWFho9bROwk8RqRwcM0ShkW6ZwO', '0905123456'),
(2, '234 Dong Da', '1998-02-02', 0, 'quantran@gmail.com', 0, 'QuanTran', '$2a$12$/2724fWWWxRUhObLpNnvi.6QtqgWFho9bROwk8RqRwcM0ShkW6ZwO', '0905234123'),
(3, '234 Dong Da', '1998-02-02', 0, 'vumap@gmail.com', 0, 'VuLe', '$2a$12$/2724fWWWxRUhObLpNnvi.6QtqgWFho9bROwk8RqRwcM0ShkW6ZwO', '0905934123');

insert into account_role (id, role_id, account_id)
values
(1, 1, 1),
(2, 2, 2),
(3, 2, 3);

insert into cart (id, date_order, account_id)
values
(1, '2023-04-27', 2),
(2, '2023-05-08', 3);

insert into cart_detail (id, deleted, quantity, cart_id, product_id)
values
(1, 0, 1, 1, 2),
(2, 0, 1, 2, 3);




















