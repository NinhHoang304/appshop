use appshop;

insert into category (id, name)
values
(1, 'IPhone'),
(2, 'IPad'),
(3, 'IMac'),
(4, 'Apple Watch'),
(5, 'AirPod'),
(6, 'Phụ kiện');

insert into product (id, code, name, price, quantity, brand, description, image, deleted, category_id)
values
(1,'SP-01','IPhone 14 Pro Max', 27290000, 20, 'Apple', 'Phone 14 Pro Max. Bắt trọn chi tiết ấn tượng với Camera Chính 48MP. Trải nghiệm iPhone theo cách hoàn toàn mới với Dynamic Island và màn hình Luôn Bật.'
,'https://shopdunk.com/images/thumbs/0008079_deep-purple_550.webp', 0, 1),
(2,'SP-02','IPhone 14 Pro', 24990000, 20, 'Apple', 'Phone 14 Pro. Bắt trọn chi tiết ấn tượng với Camera Chính 48MP. Trải nghiệm iPhone theo cách hoàn toàn mới với Dynamic Island và màn hình Luôn Bật.'
,'https://shopdunk.com/images/thumbs/0008744_iphone-14-pro-128gb_550.png', 0, 1),
(3,'SP-03','IPhone 14', 19290000, 20, 'Apple', 'Phone 14. Bắt trọn chi tiết ấn tượng với Camera Chính 48MP. Trải nghiệm iPhone theo cách hoàn toàn mới với Dynamic Island và màn hình Luôn Bật.'
,'https://shopdunk.com/images/thumbs/0009200_iphone-14-128gb_550.png', 0, 1),
(4,'SP-04','IPhone 14 Plus', 21690000, 20, 'Apple', 'Phone 14 Plus. Bắt trọn chi tiết ấn tượng với Camera Chính 48MP. Trải nghiệm iPhone theo cách hoàn toàn mới với Dynamic Island và màn hình Luôn Bật.'
,'https://shopdunk.com/images/thumbs/0009532_iphone-14-plus-128gb_550.png', 0, 1),
(5,'SP-05','iPad gen 9 10.2 inch', 6990000, 20, 'Apple', 'iPad Gen 9 (2021) Mạnh mẽ. Dễ sử dụng. Đa năng. Học sinh thích học với iPad mới. Với chip A13 Bionic mạnh mẽ, thời lượng pin bền bỉ cả ngày, màn hình Retina 10.2 inch tuyệt đẹp'
,'https://shopdunk.com/images/thumbs/0006300_silver_550.webp', 0, 2),
(6,'SP-06','iPad Pro M2 11 inch', 20790000, 20, 'Apple', 'iPad Pro. Với hiệu năng ấn tượng, kết nối không dây siêu nhanh và trải nghiệm Apple Pencil thế hệ mới. Cùng với các tính năng mới mạnh mẽ cho hiệu suất công việc và cộng tác ở iPadOS 16. iPad Pro đem đến trải nghiệm iPad cực đỉnh.'
,'https://shopdunk.com/images/thumbs/0007083_ipad-pro-m2-11-inch-wifi-128gb_550.webp', 0, 2),
(7,'SP-07','iPad Pro M2 12.9 inch', 28390000, 20, 'Apple', 'iPad Pro. Siêu mạnh mẽ với M2. Với hiệu năng ấn tượng, kết nối không dây siêu nhanh và trải nghiệm Apple Pencil thế hệ mới. Cùng với các tính năng mới mạnh mẽ cho hiệu suất công việc và cộng tác ở iPadOS 16. iPad Pro đem đến trải nghiệm iPad cực đỉnh.'
,'https://shopdunk.com/images/thumbs/0007313_ipad-pro-m2-129-inch-wifi-128gb_550.webp', 0, 2),
(8,'SP-08','iPad Gen 10th 10.9 inch', 10990000, 20, 'Apple', 'Được thiết kế lại đầy sắc màu và đa năng hơn bao giờ hết. Với thiết kế toàn màn hình, màn hình Liquid Retina 10,9 inch1 và bốn màu lộng lẫy. iPad đem lại một phương thức mạnh mẽ để sáng tạo, duy trì kết nối và hoàn tất mọi việc.'
,'https://shopdunk.com/images/thumbs/0009726_ipad-gen-10th-109-inch-wi-fi-64gb_550.webp', 0, 2),
(9,'SP-09','MacBook Pro M1 2020', 27950000, 20, 'Apple', 'Được thiết kế lại đầy sắc màu và đa năng hơn bao giờ hết. Với thiết kế toàn màn hình, màn hình Liquid Retina 10,9 inch1 và bốn màu lộng lẫy. iPad đem lại một phương thức mạnh mẽ để sáng tạo, duy trì kết nối và hoàn tất mọi việc.MacBook Pro M1 Thay đổi ngoạn mục nhờ chip Apple M1, với sức mạnh xử lý tăng thêm đến 2.8x, tốc độ xử lý đồ họa nhanh hơn 5x. Và thời lượng pin lên đến 20 giờ.'
,'https://shopdunk.com/images/thumbs/0001262_silver_550.webp', 0, 3),
(10,'SP-010','MacBook Air M2 2022', 26750000, 20, 'Apple', 'Vận hành doanh nghiệp trên MacBook Air. Siêu mạnh mẽ với chip M2 thế hệ tiếp theo, MacBook Air được thiết kế mới nay nhỏ gọn hơn bao giờ hết, kết hợp giữa hiệu năng đáng kinh ngạc và thời lượng pin lên đến 18 giờ trong vỏ nhôm mỏng đầy ấn tượng.'
,'https://shopdunk.com/images/thumbs/0008514_macbook-air-136-inch-m2-chip-with-8-core-cpu-and-8-core-gpu-256gb_550.png', 0, 3),
(11,'SP-11','Apple Watch Ultra LTE 49mm', 20390000, 20, 'Apple', 'Các tính năng và cảm biến chuyên dụng, cùng với ba dây đeo mới được thiết kế cho các hoạt động khám phá, phiêu lưu, và rèn luyện sức bền'
,'https://shopdunk.com/images/thumbs/0008914_watch-ultra-gps-cellular-49mm-titanium-case-with-alpine-loop-small_550.png', 0, 4),
(12,'SP-12','Apple Watch Series 8 41mm', 9290000, 20, 'Apple', 'Apple Watch Series 8 sở hữu các cảm biến và ứng dụng sức khỏe tối tân, vì vậy bạn có thể đo điện tâm đồ (ECG), 1 đo nhịp tim và nồng độ oxy trong máu.'
,'https://shopdunk.com/images/thumbs/0002083_product-red_550.png', 0, 4),
(13,'SP-13','AirPods 2', 2690000, 20, 'Apple', 'AirPods gen 2 with Charging Case (hộp sạc thường). AirPods 2 là kết hợp của thiết kế mang tính biểu tượng và âm thanh chất lượng cao. Đem đến trải nghiệm tai nghe không dây độc đáo và cảm giác vừa vặn, thoải mái cả ngày dài cho mọi người.'
,'https://shopdunk.com/images/thumbs/0006052_airpods-2_550.jpeg', 0, 5),
(14,'SP-14','AirPods Max', 12590000, 20, 'Apple', 'AirPods Max định nghĩa lại tai nghe chụp tai. Driver loa do Apple thiết kế cho âm thanh có độ trung thực cao. Mọi chi tiết, từ gọng đeo đến đệm tai, đều được thiết kế vừa vặn lạ thường.'
,'https://shopdunk.com/images/thumbs/0012010_sky-blue_550.webp', 0, 5),
(15,'SP-15','Magic Mouse 2', 1690000, 20, 'Apple', 'Thiết kế mới nhẹ, gọn, sử dụng sạc pin qua cáp lightning thay cho pin truyền thống. Chỉ cần sạc 2 tiếng có thể sử dụng liên tục tới 1 tháng.'
,'https://shopdunk.com/images/thumbs/0001442_white_550.jpeg', 0, 6),
(16,'SP-16','Pencil 2', 3190000, 20, 'Apple', 'Apple Pencil 2 (thế hệ thứ 2)  Gắn kết bằng nam châm. Sạc không dây. Dùng dễ chưa từng thấy.'
,'https://shopdunk.com/images/thumbs/0001417_pencil-2_550.png', 0, 6);

insert into role (id, name)
values
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');

insert into account (account_id, address, date_of_birth, deleted, email, gender, name, password, phone)
values
(1, '123 Hung Vuong', '1996-04-04', 0, 'hoang@gmail.com', 0, 'HuuHoang', '$2a$12$/2724fWWWxRUhObLpNnvi.6QtqgWFho9bROwk8RqRwcM0ShkW6ZwO', '0905123456'),
(2, '234 Dong Da', '1998-02-02', 0, 'quantran@gmail.com', 0, 'QuanTran', '$2a$12$/2724fWWWxRUhObLpNnvi.6QtqgWFho9bROwk8RqRwcM0ShkW6ZwO', '0905234123');

insert into account_role (id, role_id, account_id)
values
(1, 1, 1),
(2, 2, 2);






















