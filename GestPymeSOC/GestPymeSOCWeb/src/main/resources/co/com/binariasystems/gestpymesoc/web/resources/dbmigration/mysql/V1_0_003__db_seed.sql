/**************************************************************************************************************************************
 * Insercion de datos semilla en la tabla GPT_MOTIVOS_TERMINAC_CONTRATO
 **************************************************************************************************************************************/
INSERT INTO GPT_MOTIVOS_TERMINAC_CONTRATO(NOMBRE,DESCRIPCION,OBLIGA_INDEMNIZACION,USUARIO_CREACION,FEC_CREACION) 
VALUES('CUMPLIMIENTO DEL TERMINO', 'CUMPLIMIENTO DEL TERMINO', 'N','superadmin',CURRENT_TIMESTAMP);
INSERT INTO GPT_MOTIVOS_TERMINAC_CONTRATO(NOMBRE,DESCRIPCION,OBLIGA_INDEMNIZACION,USUARIO_CREACION,FEC_CREACION) 
VALUES('RENUNCIA VOLUNTARIA', 'RENUNCIA VOLUNTARIA', 'S','superadmin',CURRENT_TIMESTAMP);
INSERT INTO GPT_MOTIVOS_TERMINAC_CONTRATO(NOMBRE,DESCRIPCION,OBLIGA_INDEMNIZACION,USUARIO_CREACION,FEC_CREACION) 
VALUES('DESPIDO', 'DESPIDO', 'N','superadmin',CURRENT_TIMESTAMP);
INSERT INTO GPT_MOTIVOS_TERMINAC_CONTRATO(NOMBRE,DESCRIPCION,OBLIGA_INDEMNIZACION,USUARIO_CREACION,FEC_CREACION) 
VALUES('FALLECIMIENTO', 'FALLECIMIENTO', 'N','superadmin',CURRENT_TIMESTAMP);

INSERT INTO GPT_DUAL VALUES('X');
