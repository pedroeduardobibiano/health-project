INSERT INTO tb_paciente (name, cpf, data_Nascimento, rg) VALUES ('Pedro Bibiano','45123647890', '2002-05-08', '124567891');
INSERT INTO tb_paciente (name, cpf, data_Nascimento, rg) VALUES ('Joel da Silva','45971236459', '1998-01-01', '456128459');
INSERT INTO tb_paciente (name, cpf, data_Nascimento, rg) VALUES ('Agostinho Meida','78912354697', '1970-07-03', '791324976');


INSERT INTO tb_medico (name, crm, area, avaliacao) VALUES ('João Blue', '461357/SP', 'Pediatria', 4.0);
INSERT INTO tb_medico (name, crm, area, avaliacao) VALUES ('Agatha Red', '971645/RJ', 'Cardiologia', 5.0);
INSERT INTO tb_medico (name, crm, area, avaliacao) VALUES ('Vanessa Green', '798136/SC', 'Oftamologia', 4.2);

INSERT INTO tb_consulta (data_Consulta, paciente_id, medico_id) VALUES (TIMESTAMP WITH TIME ZONE '2020-07-13T20:50:07.12345Z', 1, 1)
