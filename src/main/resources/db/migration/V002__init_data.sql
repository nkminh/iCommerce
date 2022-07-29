INSERT INTO public.branch(branch_name)VALUES('Apple');
INSERT INTO public.branch(branch_name)VALUES('Samsung');

INSERT INTO public.category(category_name)VALUES('Laptop');
INSERT INTO public.category(category_name)VALUES('Mobile');
INSERT INTO public.category(category_name)VALUES('Watch');


INSERT INTO public.color(color)VALUES('Red');
INSERT INTO public.color(color)VALUES('Blue');
INSERT INTO public.color(color)VALUES('Purple');
INSERT INTO public.color(color)VALUES('Yellow');
INSERT INTO public.color(color)VALUES('Black');

INSERT INTO public.product("name", price, category_id, branch_id)VALUES('Macbook M1', 16000000, 1, 1);
INSERT INTO public.product("name", price, category_id, branch_id)VALUES('Macbook M2', 18000000, 1, 1);
INSERT INTO public.product("name", price, category_id, branch_id)VALUES('Iphone 7', 10000000, 2, 1);
INSERT INTO public.product("name", price, category_id, branch_id)VALUES('Iphone 8', 11000000, 2, 1);
INSERT INTO public.product("name", price, category_id, branch_id)VALUES('Apple Watch s1', 6000000, 3, 1);


INSERT INTO public.product("name", price, category_id, branch_id)VALUES('Sammsung Laptop1', 16000000, 1, 2);
INSERT INTO public.product("name", price, category_id, branch_id)VALUES('Samsung Note1', 9000000, 2, 2);
INSERT INTO public.product("name", price, category_id, branch_id)VALUES('Samsung Note2', 15000000, 2, 2);
INSERT INTO public.product("name", price, category_id, branch_id)VALUES('SS Watch1', 6000000, 3, 2);
INSERT INTO public.product("name", price, category_id, branch_id)VALUES('SS Watch2', 6000000, 3, 2);



INSERT INTO public.product_color(product_id, color_id)VALUES(1, 2);
INSERT INTO public.product_color(product_id, color_id)VALUES(1, 3);
INSERT INTO public.product_color(product_id, color_id)VALUES(2, 1);
INSERT INTO public.product_color(product_id, color_id)VALUES(3, 1);
INSERT INTO public.product_color(product_id, color_id)VALUES(4, 4);
INSERT INTO public.product_color(product_id, color_id)VALUES(5, 4);
INSERT INTO public.product_color(product_id, color_id)VALUES(6, 3);
INSERT INTO public.product_color(product_id, color_id)VALUES(7, 2);
INSERT INTO public.product_color(product_id, color_id)VALUES(7, 4);

INSERT INTO public.cart(status)VALUES('BUYING');

