\connect foodtrackerdb;

CREATE EXTENSION pgcrypto;

INSERT INTO public.et_users (user_id, first_name, last_name, email, password)
VALUES  
        (1, 'John', 'Smith', 'john.smith@testmail.com', crypt('testpassword', gen_salt('bf'))),
        (2, 'Annabelle', 'Smith', 'annabelle.smith@testmail.com', crypt('testpassword', gen_salt('bf')));

INSERT INTO public.et_settings (settings_id, user_id, reminder_product_expiration, suggest_recipes, push_notifications)
VALUES
        (1, 1, TRUE, TRUE, TRUE),
        (2, 2, TRUE, TRUE, TRUE);

INSERT INTO public.et_recipe (recipe_id, user_id, title, recipe_description, rating, cooking_time, difficulty, instruction, nutrition_value, image_url)
VALUES 
        (1, 1, 'Wildschweinbraten aus dem Ofen', 'Dazu passen Semmelknödel oder Brezenknödel, Blaukraut, Spätzle oder Kartoffeln.', 4.7, 30, 'einfach', 'Den Wildschweinbraten mit Salz, Pfeffer, Rosmarin, Thymian, den Knoblauchwürfelchen und dem Öl einreiben. Über Nacht zugedeckt im Kühlschrank oder einem kühlen Raum durchziehen lassen. Am nächsten Tag alles zusammen in einen Bräter (Fassungsvermögen 6 l) geben. Die Zwiebel- und Karottenwürfelchen dazugeben, den Bräter auf die Herdplatte stellen und das Fleisch mit den Zwiebeln und Karotten ringsum scharf anbraten. Das Fleisch dabei öfters wenden. Mit dem Rotwein und der Fleischbrühe oder dem Wildfond ablöschen und aufgießen. Die Tomatenstückchen dazugeben. Das Fleisch auf der Oberseite mit dem Honig einstreichen.', '654 kcal', 'https://cdn.pixabay.com/photo/2019/10/22/19/32/entrecote-4569656_960_720.jpg'),
        (2, 2, 'Einfacher Zwiebelkuchen', 'Dazu schmeckt ein Federweißer oder ein gut gekühlter Weißwein.', 4.9, 30, 'einfach', 'Mehl, Hefe, Zucker und Salz in eine Schüssel geben. In die Mitte eine Mulde drücken und das kalte Wasser hineingeben. Die weiche Butter zufügen und alles zu einem Teig kneten. Den Teig ca. 30 Minuten ruhen lassen.', '1230 kcal', 'https://cdn.pixabay.com/photo/2020/02/11/10/19/a-cake-of-bread-4839047_960_720.jpg');

INSERT INTO public.et_ingredient (ingredient_id, ingredient_name, quantity)
VALUES 
        (1, 'Wasser', '1 1/2 Cups'),
        (2, 'Salz', '1 1/2 Teaspoons'),
        (3, 'Brotmehl', '1 1/2 Cups'),
        (4, 'Zucker', '1 1/2 teaspoons'),
        (5, 'Öl', '1 1/2 Cups'),
        (6, 'Eier', '3 Stück'),
        (7, 'Milch', '1 1/2 Cups'),
        (8, 'Backpulver', '1 1/2 Cups');

INSERT INTO public.et_recipe_ingredient (recipe_id, ingredient_id)
VALUES 
        (1, 1),
        (1, 2),
        (1, 3),
        (1, 4),
        (1, 5),
        (1, 6),
        (1, 7),
        (1, 8),
        (2, 1),
        (2, 2),
        (2, 3),
        (2, 4),
        (2, 5),
        (2, 6),
        (2, 7),
        (2, 8);

INSERT INTO public.et_tag (tag_id, label)
VALUES 
        (1, 'Vegan'),
        (2, 'Mediterranisch'),
        (3, 'Italienisch'),
        (4, 'Low Carb'),
        (5, 'Fast Food'),
        (6, 'Asiatisch');

INSERT INTO public.et_user_tag (user_id, tag_id)
VALUES 
        (1, 1),
        (1, 2),
        (1, 3),
        (2, 1),
        (2, 4),
        (2, 5),
        (2, 6);

INSERT INTO public.et_recipe_tag (recipe_id, tag_id)
VALUES 
        (1, 1),
        (1, 2),
        (1, 3),
        (1, 5),
        (2, 1),
        (2, 2),
        (2, 3),
        (2, 4);

INSERT INTO public.et_inventorylist (inventorylist_id, user_id)
VALUES 
        (1, 1),
        (2, 2);

INSERT INTO public.et_shoppinglist (current_shoppinglist_id, past_shoppinglist_id)
VALUES 
        (1, NULL),
        (2, 1),
        (3, NULL),
        (4, 3);

INSERT INTO public.et_product (product_id, user_id, shoppinglist_id, inventorylist_id, product_name, expiration_date, quantity, manufacturer, nutrition_value, image_url)
VALUES 
        (1, 1, NULL, 2, 'Käse', TO_DATE('13.01.2022', 'DD.MM.YYYY'), 1, NULL, NULL, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.vectorstock.com%2Froyalty-free-vector%2Fwine-bottle-icon-simple-style-vector-22692353&psig=AOvVaw3fA46QD3uSXscflVEDJk-e&ust=1639863406680000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMiPiLrl6_QCFQAAAAAdAAAAABAD'),
        (2, 1, NULL, 2, 'Wurst', TO_DATE('13.01.2022', 'DD.MM.YYYY'), 1, NULL, NULL, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.vectorstock.com%2Froyalty-free-vector%2Fwine-bottle-icon-simple-style-vector-22692353&psig=AOvVaw3fA46QD3uSXscflVEDJk-e&ust=1639863406680000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMiPiLrl6_QCFQAAAAAdAAAAABAD'),
        (3, 1, NULL, 2, 'Brötchen', TO_DATE('15.01.2022', 'DD.MM.YYYY'), 1, NULL, NULL, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.vectorstock.com%2Froyalty-free-vector%2Fwine-bottle-icon-simple-style-vector-22692353&psig=AOvVaw3fA46QD3uSXscflVEDJk-e&ust=1639863406680000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMiPiLrl6_QCFQAAAAAdAAAAABAD'),
        (4, 1, NULL, 2, 'Marmelade', TO_DATE('20.01.2022', 'DD.MM.YYYY'), 1, NULL, NULL, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.vectorstock.com%2Froyalty-free-vector%2Fwine-bottle-icon-simple-style-vector-22692353&psig=AOvVaw3fA46QD3uSXscflVEDJk-e&ust=1639863406680000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMiPiLrl6_QCFQAAAAAdAAAAABAD'),
        (5, 1, NULL, 2, 'Butter', TO_DATE('21.01.2022', 'DD.MM.YYYY'), 1, NULL, NULL, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.vectorstock.com%2Froyalty-free-vector%2Fwine-bottle-icon-simple-style-vector-22692353&psig=AOvVaw3fA46QD3uSXscflVEDJk-e&ust=1639863406680000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMiPiLrl6_QCFQAAAAAdAAAAABAD'),
        (6, 1, NULL, 2, 'Tiefkühl Pizza', TO_DATE('21.01.2022', 'DD.MM.YYYY'), 1, NULL, NULL, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.vectorstock.com%2Froyalty-free-vector%2Fwine-bottle-icon-simple-style-vector-22692353&psig=AOvVaw3fA46QD3uSXscflVEDJk-e&ust=1639863406680000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMiPiLrl6_QCFQAAAAAdAAAAABAD'),
        (7, 1, NULL, 2, 'Butter Gemüse', TO_DATE('23.01.2022', 'DD.MM.YYYY'), 1, NULL, NULL, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.vectorstock.com%2Froyalty-free-vector%2Fwine-bottle-icon-simple-style-vector-22692353&psig=AOvVaw3fA46QD3uSXscflVEDJk-e&ust=1639863406680000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMiPiLrl6_QCFQAAAAAdAAAAABAD'),
        (8, 1, NULL, 2, 'Karotten', TO_DATE('23.01.2022', 'DD.MM.YYYY'), 1, NULL, NULL, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.vectorstock.com%2Froyalty-free-vector%2Fwine-bottle-icon-simple-style-vector-22692353&psig=AOvVaw3fA46QD3uSXscflVEDJk-e&ust=1639863406680000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMiPiLrl6_QCFQAAAAAdAAAAABAD'),
        (9, 1, NULL, 2, 'Wein', TO_DATE('23.01.2022', 'DD.MM.YYYY'), 1, NULL, NULL, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.vectorstock.com%2Froyalty-free-vector%2Fwine-bottle-icon-simple-style-vector-22692353&psig=AOvVaw3fA46QD3uSXscflVEDJk-e&ust=1639863406680000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMiPiLrl6_QCFQAAAAAdAAAAABAD'),
        (10, 1, 2, NULL, 'Toast', TO_DATE('24.01.2022', 'DD.MM.YYYY'), 1, NULL, NULL, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.vectorstock.com%2Froyalty-free-vector%2Fwine-bottle-icon-simple-style-vector-22692353&psig=AOvVaw3fA46QD3uSXscflVEDJk-e&ust=1639863406680000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMiPiLrl6_QCFQAAAAAdAAAAABAD'),
        (11, 1, 2, NULL, 'Müsli', TO_DATE('24.01.2022', 'DD.MM.YYYY'), 1, NULL, NULL, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.vectorstock.com%2Froyalty-free-vector%2Fwine-bottle-icon-simple-style-vector-22692353&psig=AOvVaw3fA46QD3uSXscflVEDJk-e&ust=1639863406680000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMiPiLrl6_QCFQAAAAAdAAAAABAD'),
        (12, 1, 2, NULL, 'Nudeln', TO_DATE('24.01.2022', 'DD.MM.YYYY'), 1, NULL, NULL, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.vectorstock.com%2Froyalty-free-vector%2Fwine-bottle-icon-simple-style-vector-22692353&psig=AOvVaw3fA46QD3uSXscflVEDJk-e&ust=1639863406680000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMiPiLrl6_QCFQAAAAAdAAAAABAD'),
        (13, 1, 2, NULL, 'Spaghetti', TO_DATE('25.01.2022', 'DD.MM.YYYY'), 1, NULL, NULL, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.vectorstock.com%2Froyalty-free-vector%2Fwine-bottle-icon-simple-style-vector-22692353&psig=AOvVaw3fA46QD3uSXscflVEDJk-e&ust=1639863406680000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMiPiLrl6_QCFQAAAAAdAAAAABAD'),
        (14, 1, 2, NULL, 'Orangensaft', TO_DATE('25.01.2022', 'DD.MM.YYYY'), 1, NULL, NULL, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.vectorstock.com%2Froyalty-free-vector%2Fwine-bottle-icon-simple-style-vector-22692353&psig=AOvVaw3fA46QD3uSXscflVEDJk-e&ust=1639863406680000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMiPiLrl6_QCFQAAAAAdAAAAABAD'),
        (15, 1, 1, NULL, 'Grünkohl', TO_DATE('25.01.2022', 'DD.MM.YYYY'), 1, NULL, NULL, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.vectorstock.com%2Froyalty-free-vector%2Fwine-bottle-icon-simple-style-vector-22692353&psig=AOvVaw3fA46QD3uSXscflVEDJk-e&ust=1639863406680000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMiPiLrl6_QCFQAAAAAdAAAAABAD'),
        (16, 1, 1, NULL, 'Bananen', TO_DATE('26.01.2022', 'DD.MM.YYYY'), 1, NULL, NULL, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.vectorstock.com%2Froyalty-free-vector%2Fwine-bottle-icon-simple-style-vector-22692353&psig=AOvVaw3fA46QD3uSXscflVEDJk-e&ust=1639863406680000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMiPiLrl6_QCFQAAAAAdAAAAABAD'),
        (17, 1, 1, NULL, 'Äpfel', TO_DATE('26.01.2022', 'DD.MM.YYYY'), 1, NULL, NULL, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.vectorstock.com%2Froyalty-free-vector%2Fwine-bottle-icon-simple-style-vector-22692353&psig=AOvVaw3fA46QD3uSXscflVEDJk-e&ust=1639863406680000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMiPiLrl6_QCFQAAAAAdAAAAABAD'),
        (18, 1, 1, NULL, 'Nüsse', TO_DATE('26.01.2022', 'DD.MM.YYYY'), 1, NULL, NULL, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.vectorstock.com%2Froyalty-free-vector%2Fwine-bottle-icon-simple-style-vector-22692353&psig=AOvVaw3fA46QD3uSXscflVEDJk-e&ust=1639863406680000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMiPiLrl6_QCFQAAAAAdAAAAABAD'),
        (19, 2, NULL, 2, 'Studentenfutter', TO_DATE('28.01.2022', 'DD.MM.YYYY'), 1, NULL, NULL, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.vectorstock.com%2Froyalty-free-vector%2Fwine-bottle-icon-simple-style-vector-22692353&psig=AOvVaw3fA46QD3uSXscflVEDJk-e&ust=1639863406680000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMiPiLrl6_QCFQAAAAAdAAAAABAD'),
        (20, 2, NULL, 2, 'Harzer Käse', TO_DATE('28.01.2022', 'DD.MM.YYYY'), 1, NULL, NULL, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.vectorstock.com%2Froyalty-free-vector%2Fwine-bottle-icon-simple-style-vector-22692353&psig=AOvVaw3fA46QD3uSXscflVEDJk-e&ust=1639863406680000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMiPiLrl6_QCFQAAAAAdAAAAABAD'),
        (21, 2, NULL, 2, 'Geflügel', TO_DATE('28.01.2022', 'DD.MM.YYYY'), 1, NULL, NULL, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.vectorstock.com%2Froyalty-free-vector%2Fwine-bottle-icon-simple-style-vector-22692353&psig=AOvVaw3fA46QD3uSXscflVEDJk-e&ust=1639863406680000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMiPiLrl6_QCFQAAAAAdAAAAABAD'),
        (22, 2, NULL, 2, 'Nutella', TO_DATE('29.01.2022', 'DD.MM.YYYY'), 1, NULL, NULL, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.vectorstock.com%2Froyalty-free-vector%2Fwine-bottle-icon-simple-style-vector-22692353&psig=AOvVaw3fA46QD3uSXscflVEDJk-e&ust=1639863406680000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMiPiLrl6_QCFQAAAAAdAAAAABAD'),
        (23, 2, NULL, 2, 'Pizza', TO_DATE('30.01.2022', 'DD.MM.YYYY'), 1, NULL, NULL, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.vectorstock.com%2Froyalty-free-vector%2Fwine-bottle-icon-simple-style-vector-22692353&psig=AOvVaw3fA46QD3uSXscflVEDJk-e&ust=1639863406680000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMiPiLrl6_QCFQAAAAAdAAAAABAD'),
        (24, 2, NULL, 2, 'Box Sushi', TO_DATE('22.02.2022', 'DD.MM.YYYY'), 1, NULL, NULL, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.vectorstock.com%2Froyalty-free-vector%2Fwine-bottle-icon-simple-style-vector-22692353&psig=AOvVaw3fA46QD3uSXscflVEDJk-e&ust=1639863406680000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMiPiLrl6_QCFQAAAAAdAAAAABAD'),
        (25, 2, NULL, 2, 'Grünes Curry', TO_DATE('22.02.2022', 'DD.MM.YYYY'), 1, NULL, NULL, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.vectorstock.com%2Froyalty-free-vector%2Fwine-bottle-icon-simple-style-vector-22692353&psig=AOvVaw3fA46QD3uSXscflVEDJk-e&ust=1639863406680000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMiPiLrl6_QCFQAAAAAdAAAAABAD'),
        (26, 2, NULL, 2, 'Winter Möhren', TO_DATE('22.02.2022', 'DD.MM.YYYY'), 1, NULL, NULL, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.vectorstock.com%2Froyalty-free-vector%2Fwine-bottle-icon-simple-style-vector-22692353&psig=AOvVaw3fA46QD3uSXscflVEDJk-e&ust=1639863406680000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMiPiLrl6_QCFQAAAAAdAAAAABAD'),
        (27, 2, NULL, 2, 'Kuchen', TO_DATE('22.02.2022', 'DD.MM.YYYY'), 1, NULL, NULL, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.vectorstock.com%2Froyalty-free-vector%2Fwine-bottle-icon-simple-style-vector-22692353&psig=AOvVaw3fA46QD3uSXscflVEDJk-e&ust=1639863406680000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMiPiLrl6_QCFQAAAAAdAAAAABAD'),
        (28, 2, 2, NULL, 'Syrup', TO_DATE('22.02.2022', 'DD.MM.YYYY'), 1, NULL, NULL, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.vectorstock.com%2Froyalty-free-vector%2Fwine-bottle-icon-simple-style-vector-22692353&psig=AOvVaw3fA46QD3uSXscflVEDJk-e&ust=1639863406680000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMiPiLrl6_QCFQAAAAAdAAAAABAD'),
        (29, 2, 2, NULL, 'Weißwein', TO_DATE('22.02.2022', 'DD.MM.YYYY'), 1, NULL, NULL, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.vectorstock.com%2Froyalty-free-vector%2Fwine-bottle-icon-simple-style-vector-22692353&psig=AOvVaw3fA46QD3uSXscflVEDJk-e&ust=1639863406680000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMiPiLrl6_QCFQAAAAAdAAAAABAD'),
        (30, 2, 2, NULL, 'Zitronen', TO_DATE('22.02.2022', 'DD.MM.YYYY'), 1, NULL, NULL, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.vectorstock.com%2Froyalty-free-vector%2Fwine-bottle-icon-simple-style-vector-22692353&psig=AOvVaw3fA46QD3uSXscflVEDJk-e&ust=1639863406680000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMiPiLrl6_QCFQAAAAAdAAAAABAD'),
        (31, 2, 2, NULL, 'Knoblauch', TO_DATE('22.02.2022', 'DD.MM.YYYY'), 1, NULL, NULL, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.vectorstock.com%2Froyalty-free-vector%2Fwine-bottle-icon-simple-style-vector-22692353&psig=AOvVaw3fA46QD3uSXscflVEDJk-e&ust=1639863406680000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMiPiLrl6_QCFQAAAAAdAAAAABAD'),
        (32, 2, 3, NULL, 'Zwiebeln', TO_DATE('22.03.2022', 'DD.MM.YYYY'), 1, NULL, NULL, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.vectorstock.com%2Froyalty-free-vector%2Fwine-bottle-icon-simple-style-vector-22692353&psig=AOvVaw3fA46QD3uSXscflVEDJk-e&ust=1639863406680000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMiPiLrl6_QCFQAAAAAdAAAAABAD'),
        (33, 2, 3, NULL, 'Frischkäse', TO_DATE('22.03.2022', 'DD.MM.YYYY'), 1, NULL, NULL, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.vectorstock.com%2Froyalty-free-vector%2Fwine-bottle-icon-simple-style-vector-22692353&psig=AOvVaw3fA46QD3uSXscflVEDJk-e&ust=1639863406680000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMiPiLrl6_QCFQAAAAAdAAAAABAD'),
        (34, 2, 3, NULL, 'Eier', TO_DATE('22.03.2022', 'DD.MM.YYYY'), 1, NULL, NULL, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.vectorstock.com%2Froyalty-free-vector%2Fwine-bottle-icon-simple-style-vector-22692353&psig=AOvVaw3fA46QD3uSXscflVEDJk-e&ust=1639863406680000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMiPiLrl6_QCFQAAAAAdAAAAABAD'),
        (35, 2, 3, NULL, 'Mehl', TO_DATE('22.03.2022', 'DD.MM.YYYY'), 1, NULL, NULL, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.vectorstock.com%2Froyalty-free-vector%2Fwine-bottle-icon-simple-style-vector-22692353&psig=AOvVaw3fA46QD3uSXscflVEDJk-e&ust=1639863406680000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMiPiLrl6_QCFQAAAAAdAAAAABAD'),
        (36, 2, 3, NULL, 'Katzenfutter', TO_DATE('22.03.2022', 'DD.MM.YYYY'), 1, NULL, NULL, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.vectorstock.com%2Froyalty-free-vector%2Fwine-bottle-icon-simple-style-vector-22692353&psig=AOvVaw3fA46QD3uSXscflVEDJk-e&ust=1639863406680000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMiPiLrl6_QCFQAAAAAdAAAAABAD');