CREATE TABLE "category" (
                            id bigserial NOT NULL,
                            category_name text NOT NULL,
                            CONSTRAINT category_pkey PRIMARY KEY (id)
);

CREATE TABLE "branch" (
                          id bigserial NOT NULL,
                          branch_name text NOT NULL,
                          CONSTRAINT branch_pkey PRIMARY KEY (id)
);

CREATE TABLE "product" (
                           id bigserial NOT NULL,
                           name text NOT NULL,
                           price numeric NOT null default 0,
                           category_id int8 NOT NULL,
                           branch_id int8 NOT NULL,
                           CONSTRAINT product_pkey PRIMARY KEY (id)
);
ALTER TABLE "product" ADD CONSTRAINT fk_category_id_of_product FOREIGN KEY (category_id) REFERENCES category(id);
ALTER TABLE "product" ADD CONSTRAINT fk_branch_id_of_product FOREIGN KEY (branch_id) REFERENCES branch(id);

CREATE TABLE "cart" (
                        id bigserial NOT NULL,
                        status text NULL,
                        CONSTRAINT cart_pkey PRIMARY KEY (id)
);

CREATE TABLE "detail_cart" (
                               id bigserial NOT NULL,
                               product_id int8 NOT NULL,
                               cart_id int8 NOT NULL,
                               count int8 NOT NULL,
                               CONSTRAINT detail_cart_pkey PRIMARY KEY (id)
);
ALTER TABLE "detail_cart" ADD CONSTRAINT fk_product_id_of_detail_cart FOREIGN KEY (product_id) REFERENCES product(id);
ALTER TABLE "detail_cart" ADD CONSTRAINT fk_cart_id_of_detail_cart FOREIGN KEY (cart_id) REFERENCES cart(id);


CREATE TABLE "color" (
                         id bigserial NOT NULL,
                         color text NOT NULL,
                         CONSTRAINT color_pkey PRIMARY KEY (id)
);

CREATE TABLE "product_color" (
                                 product_id int8 NOT NULL,
                                 color_id int8 NOT NULL,
                                 CONSTRAINT color_product_pkey PRIMARY KEY (product_id, color_id)
);

ALTER TABLE "product_color" ADD CONSTRAINT fk_product_id_of_product_color FOREIGN KEY (product_id) REFERENCES product(id);
ALTER TABLE "product_color" ADD CONSTRAINT fk_color_id_of_product_color FOREIGN KEY (color_id) REFERENCES color(id);
