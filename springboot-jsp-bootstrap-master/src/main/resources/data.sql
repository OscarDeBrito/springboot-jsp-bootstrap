insert into "users"("id","user_name","password", "email", "full_name", "mobile", "user_id") values
(1, 'Tiago Lopes', '123456', 'tlopes@gmail.com', 'Tiago Lopes', '$2a$10$XBQ9jnH3tqdUSqeTRfvrQOFyZsqxPym29nGKrlyhYUUYU7jg9dvMC', 1),
(2, 'Tiago Santos', '123456', 'tlopes@gmail.com', 'Tiago Santos','$2a$10$XBQ9jnH3tqdUSqeTRfvrQOFyZsqxPym29nGKrlyhYUUYU7jg9dvMC',1);


NSERT INTO public.role(
    id, name)
    VALUES (1, 'ROLE_LOGIN');

insert into "pessoa"("id","user_name","password", "email", "full_name", "nome", "mobile", "user_id","cpf", "tipo_pessoa", "data_nascimento", "gerente", "funcionario", "matricula") values
                                                                                                                                                                                        (1, 'tal', '$2a$10$XBQ9jnH3tqdUSqeTRfvrQOFyZsqxPym29nGKrlyhYUUYU7jg9dvMC', 'tlopes@gmail.com', 'Tiago Lopes', 'Tiago Lopes', '1187635463', 1, '32534563546', 'users', '03/10/1979', true, false, '28383284'),
                                                                                                                                                                                        (2, 'Tiago Santos', '$2a$10$XBQ9jnH3tqdUSqeTRfvrQOFyZsqxPym29nGKrlyhYUUYU7jg9dvMC', 'tlopes@gmail.com', 'Tiago Santos', 'Tiago Santos','1187635463', 1, '12534563534','users', '03/10/1979', false, true, '28383284');