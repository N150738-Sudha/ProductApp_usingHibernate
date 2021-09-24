package com;

/**
 * Tufail Product App Main
 * 
 * CREATE TABLE hr.products (
	productid int4 NOT NULL,
	productname varchar(20) NOT NULL,
	quantityonhand int4 NOT NULL,
	price int4 NOT NULL,
	"comments" varchar(20) NULL,
	CONSTRAINT comments_check_cons CHECK (((comments)::text = ANY ((ARRAY['Excellent'::character varying, 'Awsome'::character varying, 'Good'::character varying, 'Ok'::character varying])::text[]))),
	CONSTRAINT products_pkey PRIMARY KEY (productid),
	CONSTRAINT products_productname_key UNIQUE (productname)
);
 */
public class App {
	public static void main(String[] args) {
		System.out.println("#########Tufail's Product App");
		ProductApp productApp = new ProductApp();
		productApp.startProductApp();
	}
}
