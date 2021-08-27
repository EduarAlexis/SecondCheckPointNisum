INSERT INTO public.currency
(code, symbol)
VALUES('CLP', '$');
INSERT INTO public.currency
(code, symbol)
VALUES('COP', '$');
INSERT INTO public.currency
(code, symbol)
VALUES('USD', '$');

INSERT INTO public.item
(description, name, price, sku, thumbnail, currency_id)
VALUES('', 'ipad', 900, '1234', 'http://ishop.com/ipad.jpg', 1);

INSERT INTO public.image
(url, item_id)
VALUES('http://ishop.com/ipad.jpg', 1);