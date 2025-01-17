INSERT INTO medico.doctor
(`ID_DOCTOR`,`DOCTOR_NAME`,`DOCTOR_EMAIL`)
VALUES
(5,'Rafael Costa Neto', 'rafael.neto27@gmail.com');
INSERT INTO `medico`.`doctor`
(`ID_DOCTOR`,`DOCTOR_NAME`,`DOCTOR_EMAIL`)
VALUES
(2,'Dayane Oliveira Nascimento', 'dayane.nscimento01@hotmail.com');
INSERT INTO `medico`.`doctor`
(`ID_DOCTOR`,`DOCTOR_NAME`,`DOCTOR_EMAIL`)
VALUES
(3,'João Batista Ferreira', 'joao39@outlook.com');

INSERT INTO medico.user
(`USER_NAME`,`USER_PASSWORD`,`USER_EMAIL`)
VALUES
('Renata Sorrah','123', 'renata@outlook.com');

INSERT INTO medico.appointment
(`ID_APPOINTMENT_DOCTOR`,`ID_APPOINTMENT_USER`,`DESCRIPTION`,`CREATION_DATE`)
VALUES
(2,1,'Customer reported fever','2025-01-09');