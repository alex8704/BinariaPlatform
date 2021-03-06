/********************************************************************************************
*						GestPymeSOC - DataBase Schemas and Objects Script
* +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
* Prefijo MAT_, para tablas maestras que apliquen para cualquier aplicacion ademas de GestPymeSOC,
* Prefijo GPT_, para tablas del modelo propio de GestPymeSOC
* Prefijo SEGT_, paratablas del modelo de Seguridad Centralizado
* ----------------------------------------------------------------------------------------------------------------------------
* Usar el prefijo ID_, concatenado con el sufijo de la tabla, para columnas de tipo Clave primaria numerica
* Ejemplo: Tabla MAT_PAISES, tiene el sufijo "PAISES" por tanto la columna de clave primaria se llama ID_PAIS
* ----------------------------------------------------------------------------------------------------------------------------
* Para columnas que representen codigos estandar establecidos por entidades gubernamentales o como codificacion
* propia definida internamente, se usa el prefijo COD_
* ----------------------------------------------------------------------------------------------------------------------------
* Para columnas que hacen referencia a valores cuantitativos, por ejemplo Valor de compra, se usa el prefijo
* VLR_, seguido del sufijo correspondiente
*********************************************************************************************/

CREATE TABLE MATCENTRAL.MAT_PAISES(
	ID_PAIS INTEGER NOT NULL AUTO_INCREMENT,
	NOMBRE VARCHAR(128) NOT NULL,
	COD_DANE VARCHAR(4) NOT NULL,
	CONSTRAINT PAISES_PK PRIMARY KEY (ID_PAIS)
);

CREATE TABLE MATCENTRAL.MAT_DEPARTAMENTOS(
	ID_DEPARTAMENTO INTEGER NOT NULL AUTO_INCREMENT,
	COD_DEPARTAMENTO VARCHAR(3) NOT NULL,
	NOMBRE VARCHAR(128) NOT NULL,
	ID_PAIS INTEGER NOT NULL,
	CONSTRAINT DEPARTAMENTOS_PK PRIMARY KEY (ID_DEPARTAMENTO)
);

CREATE TABLE MATCENTRAL.MAT_CIUDADES(
	ID_CIUDAD INTEGER NOT NULL AUTO_INCREMENT,
	COD_CIUDAD VARCHAR(6) NOT NULL,
	NOMBRE VARCHAR(128) NOT NULL,
	ID_DEPARTAMENTO INTEGER NOT NULL,
	CONSTRAINT CIUDADES_PK PRIMARY KEY (ID_CIUDAD)
);

CREATE TABLE MATCENTRAL.MAT_BANCOS(
	ID_BANCO INTEGER NOT NULL AUTO_INCREMENT,
	COD_BANCO VARCHAR(15),
	NOMBRE VARCHAR(128) NOT NULL,
	ES_VIGENTE VARCHAR(1) DEFAULT 'S',
	CONSTRAINT BANCOS_PK PRIMARY KEY (ID_BANCO)
);

CREATE TABLE MATCENTRAL.MAT_AGRUPADOR_ESTADOS(
	ID_AGRUPADOR INTEGER NOT NULL AUTO_INCREMENT,
	COD_AGRUPADOR VARCHAR(64),
	NOMBRE VARCHAR(128),
	CONSTRAINT AGRUPADOR_ESTADOS_PK PRIMARY KEY (ID_AGRUPADOR)
);

CREATE TABLE MATCENTRAL.MAT_ESTADOS(
	ID_ESTADO INTEGER NOT NULL AUTO_INCREMENT,
	ID_AGRUPADOR INTEGER NOT NULL,
	COD_ESTADO VARCHAR(64) NOT NULL,
	NOMBRE VARCHAR(128) NOT NULL,
	DESCRIPCION VARCHAR(256),
	ES_ACTIVO VARCHAR(1) DEFAULT 'S',
	CONSTRAINT ESTADOS_PK PRIMARY KEY (ID_ESTADO)
);

CREATE TABLE MATCENTRAL.MAT_MAESTRAS(
	ID_MAESTRA INTEGER NOT NULL AUTO_INCREMENT,
	COD_MAESTRA VARCHAR(15) NOT NULL,
	NOMBRE VARCHAR(128) NOT NULL,
	CONSTRAINT MAESTRAS_PK PRIMARY KEY (ID_MAESTRA)
);

CREATE TABLE MATCENTRAL.MAT_DATOS_MAESTRAS(
	ID_DATO_MAESTRA INTEGER NOT NULL AUTO_INCREMENT,
	COD_DATO_MAESTRA VARCHAR(15) NOT NULL,
	ID_MAESTRA INTEGER NOT NULL,
	DESCRIPCION VARCHAR(128) NOT NULL,
	CONSTRAINT DATOS_MAESTRAS_PK PRIMARY KEY (ID_DATO_MAESTRA)
);

CREATE TABLE MATCENTRAL.MAT_TIPOS_CONTRIBUYENTE(
	ID_TIPO_CONTRIBUYENTE INTEGER NOT NULL AUTO_INCREMENT,
	COD_TIPO_CONTRIBUYENTE VARCHAR(15),
	NOMBRE VARCHAR(128) NOT NULL,
	DESCRIPCION VARCHAR(128),
	RETEFUENTE_RENTA_APLICABLE VARCHAR(1),
	RETEFUENTE_IVA_APLICABLE VARCHAR(1),
	RETEFUENTE_ICA_APLICABLE VARCHAR(1),
	RETEFUENTE_CRE_APLICABLE VARCHAR(1),
	DECLARA_IVA VARCHAR(1),
	DECLARA_RENTA VARCHAR(1),
	DECLARA_ICA VARCHAR(1),
	DECLARA_CREE VARCHAR(1),
	USUARIO_CREACION VARCHAR(30) NOT NULL,
	USUARIO_MODIFICACION VARCHAR(30),
	FEC_CREACION TIMESTAMP NOT NULL,
	FEC_MODIFICACION TIMESTAMP,
	CONSTRAINT TIPOS_CONTRIBUYENTE_PK PRIMARY KEY (ID_TIPO_CONTRIBUYENTE)
);

/*******************************************************************************************************************************************
	Grupos Tarifarios que definen las tarifas para las actividades economicas
*******************************************************************************************************************************************/
CREATE TABLE MATCENTRAL.MAT_GRUPOS_TARIFA_ACTI_ECONOM(
	ID_GRUPO_TARIFARIO INTEGER NOT NULL AUTO_INCREMENT,
	COD_RUBRO_ECONOMICO VARCHAR(64) NOT NULL,
	COD_GRUPO_TARIFARIO VARCHAR(15) NOT NULL,
	NOMBRE VARCHAR(256),
	UVT_GRAVABLE NUMERIC(16,2),
	VLR_TARIFA_X_MIL_VIGENTE NUMERIC(6,3),
	USUARIO_CREACION VARCHAR(30) NOT NULL,
	USUARIO_MODIFICACION VARCHAR(30),
	FEC_CREACION TIMESTAMP NOT NULL,
	FEC_MODIFICACION TIMESTAMP,
	CONSTRAINT GRUPOS_TARIFA_ACTI_ECONOM_PK PRIMARY KEY (ID_GRUPO_TARIFARIO)
);

CREATE TABLE MATCENTRAL.MAT_ACTIVIDADES_ECONOMICAS(
	ID_ACTIVIDAD_ECONOMICA INTEGER NOT NULL AUTO_INCREMENT,
	ID_GRUPO_TARIFARIO INTEGER NOT NULL,
	COD_ACTIVIDAD_CIIU VARCHAR(15),
	NOMBRE VARCHAR(512) NOT NULL,
	DESCRIPCION VARCHAR(512),
	CONSTRAINT ACTIVIDADES_ECONOMICAS_PK PRIMARY KEY (ID_ACTIVIDAD_ECONOMICA)
);

CREATE TABLE MATCENTRAL.MAT_TIPOS_IDENTIFICACION(
	ID_TIPO_IDENTIFICACION INTEGER NOT NULL AUTO_INCREMENT,
	COD_TIPO_IDENTIFICACION VARCHAR(15) NOT NULL,
	NOMBRE_CORTO VARCHAR(15) NOT NULL,
	DESCRIPCION VARCHAR(128),
	CONSTRAINT TIPOS_IDENTIFICACION_PK PRIMARY KEY (ID_TIPO_IDENTIFICACION)
);

CREATE TABLE MATCENTRAL.MAT_GRUPOS_EMPRESARIALES(
	ID_GRUPO_EMPRESARIAL INTEGER NOT NULL AUTO_INCREMENT,
	RAZON_SOCIAL VARCHAR(128) NOT NULL,
	IDENTIFICACION_TRIBUTARIA VARCHAR(10) NOT NULL,
	DIGITO_VERIFICACION INTEGER NOT NULL,
	ID_CIUDAD INTEGER NOT NULL,
	NUM_PBX VARCHAR(15),
	NUM_TELEFONO1 VARCHAR(15),
	NUM_TELEFONO2 VARCHAR(15),
	USUARIO_CREACION VARCHAR(30) NOT NULL,
	USUARIO_MODIFICACION VARCHAR(30),
	FEC_CREACION TIMESTAMP NOT NULL,
	FEC_MODIFICACION TIMESTAMP,
	COD_TIPO_VIA_PPAL VARCHAR(15),
	NUMERO_VIA_PPAL INTEGER,
	LETRAS_VIA_PPAL VARCHAR(3),
	BIS VARCHAR(3),
	LETRAS_BIS VARCHAR(3),
	CUADRANTE_VIA_PPAL VARCHAR(10),
	COD_COMPLEM_VIA_PPAL VARCHAR(15),
	DETAL_COMPLEM_VIA_PPAL VARCHAR(40),
	NUMERO_VIA_SECUND INTEGER,
	LETRAS_VIA_SECUND VARCHAR(3),
	NUMERO_VIA_COMPLEM INTEGER,
	CUADRANTE_VIA_COMPLEM VARCHAR(10),
	COD_COMPLEM_VIA_COMPLEM VARCHAR(15),
	DETAL_COMPLEM_VIA_COMPLEM VARCHAR(40),
	CONSTRAINT GRUPOS_EMPRESARIALES_PK PRIMARY KEY (ID_GRUPO_EMPRESARIAL)
);

CREATE TABLE MATCENTRAL.MAT_EMPRESAS(
	ID_EMPRESA INTEGER NOT NULL AUTO_INCREMENT,
	RAZON_SOCIAL VARCHAR(128) NOT NULL,
	IDENTIFICACION_TRIBUTARIA VARCHAR(10),
	DIGITO_VERIFICACION INTEGER NOT NULL,
	ID_GRUPO_EMPRESARIAL INTEGER,
	ID_CIUDAD INTEGER NOT NULL,
	NUM_PBX VARCHAR(15),
	NUM_TELEFONO1 VARCHAR(15),
	NUM_TELEFONO2 VARCHAR(15),
	CORREO_ELECTRONICO VARCHAR(256),
	ID_TIPO_CONTRIBUYENTE INTEGER NOT NULL,
	ID_ACTIVIDAD_ECONOMICA INTEGER NOT NULL,
	ID_BANCO_CONVENIO_NOMINA INTEGER,
	COD_TIPO_PERIODO_NOMINA VARCHAR(30) NOT NULL,
	USUARIO_CREACION VARCHAR(30) NOT NULL,
	USUARIO_MODIFICACION VARCHAR(30),
	FEC_CREACION TIMESTAMP NOT NULL,
	FEC_MODIFICACION TIMESTAMP,
	COD_TIPO_VIA_PPAL VARCHAR(15),
	NUMERO_VIA_PPAL INTEGER,
	LETRAS_VIA_PPAL VARCHAR(3),
	BIS VARCHAR(3),
	LETRAS_BIS VARCHAR(3),
	CUADRANTE_VIA_PPAL VARCHAR(10),
	COD_COMPLEM_VIA_PPAL VARCHAR(15),
	DETAL_COMPLEM_VIA_PPAL VARCHAR(40),
	NUMERO_VIA_SECUND INTEGER,
	LETRAS_VIA_SECUND VARCHAR(3),
	NUMERO_VIA_COMPLEM INTEGER,
	CUADRANTE_VIA_COMPLEM VARCHAR(10),
	COD_COMPLEM_VIA_COMPLEM VARCHAR(15),
	DETAL_COMPLEM_VIA_COMPLEM VARCHAR(40),
	CONSTRAINT EMPRESAS_PK PRIMARY KEY (ID_EMPRESA)
);


/*******************************************************************************************************************************************
 * Conceptos de pago para determinar las tarifas de retenciones
 * durante las diferentes transacciones de salida de dinero. Ej: Comprobantes de Egreso, etc
 *******************************************************************************************************************************************/
CREATE TABLE MATCENTRAL.MAT_CONCEPTOS_PAGO(
	ID_CONCEPTO_PAGO INTEGER NOT NULL AUTO_INCREMENT,
	NOMBRE VARCHAR(128) NOT NULL,
	DESCRIPCION VARCHAR(128),
	APLICA_EMPLEADOS VARCHAR(1),
	APLICA_PROVEEDORES VARCHAR(1),
	USUARIO_CREACION VARCHAR(30) NOT NULL,
	USUARIO_MODIFICACION VARCHAR(30),
	FEC_CREACION TIMESTAMP NOT NULL,
	FEC_MODIFICACION TIMESTAMP,
	CONSTRAINT CONCEPTOS_PAGO_PK PRIMARY KEY (ID_CONCEPTO_PAGO)
);

CREATE TABLE MATCENTRAL.MAT_CONFIG_RETENCIONES(
	ID_CONFIG_RETENCION INTEGER NOT NULL AUTO_INCREMENT,
	COD_TIPO_RETENCION VARCHAR(64) NOT NULL,
	COD_TIPO_PERSONA VARCHAR(64),
	ID_CONCEPTO_PAGO INTEGER NOT NULL,
	UVT_GRAVABLE NUMERIC(16,2) NOT NULL,
	VLR_TARIFA NUMERIC(6,3) NOT NULL,
	USUARIO_CREACION VARCHAR(30) NOT NULL,
	USUARIO_MODIFICACION VARCHAR(30),
	FEC_CREACION TIMESTAMP NOT NULL,
	FEC_MODIFICACION TIMESTAMP,
	CONSTRAINT CONFIG_RETENCIONES_PK PRIMARY KEY (ID_CONFIG_RETENCION)
);

CREATE TABLE MATCENTRAL.MAT_PARAMETROS_CONFIG(
	ID_PARAM_CONFIG INTEGER NOT NULL AUTO_INCREMENT,
	COD_PARAM_CONFIG VARCHAR(64) NOT NULL,
	COD_APLICACION VARCHAR(64),
	DESCRIPCION VARCHAR(128),
	VLR_NUMERICO NUMERIC(16,2),
	VLR_CADENA VARCHAR(256),
	USUARIO_CREACION VARCHAR(30) NOT NULL,
	USUARIO_MODIFICACION VARCHAR(30),
	FEC_CREACION TIMESTAMP NOT NULL,
	FEC_MODIFICACION TIMESTAMP,
	CONSTRAINT PARAMETROS_CONFIG_PK PRIMARY KEY (ID_PARAM_CONFIG)
);

CREATE TABLE MATCENTRAL.MAT_EPSS(
	ID_EPS INTEGER NOT NULL AUTO_INCREMENT,
	COD_EPS VARCHAR(15),
	NOMBRE VARCHAR(128) NOT NULL,
	ES_VIGENTE VARCHAR(1) DEFAULT 'S',
	CONSTRAINT EPSS_PK PRIMARY KEY (ID_EPS)
);

CREATE TABLE MATCENTRAL.MAT_AFPS(
	ID_AFP INTEGER NOT NULL AUTO_INCREMENT,
	COD_AFP VARCHAR(15),
	NOMBRE VARCHAR(128) NOT NULL,
	ES_VIGENTE VARCHAR(1) DEFAULT 'S',
	CONSTRAINT AFPS_PK PRIMARY KEY (ID_AFP)
);

CREATE TABLE MATCENTRAL.MAT_ARLS(
	ID_ARL INTEGER NOT NULL AUTO_INCREMENT,
	COD_ARL VARCHAR(15),
	NOMBRE VARCHAR(128) NOT NULL,
	ES_VIGENTE VARCHAR(1) DEFAULT 'S',
	CONSTRAINT ARLS_PK PRIMARY KEY (ID_ARL)
);

CREATE TABLE MATCENTRAL.MAT_CCFS(
	ID_CCF INTEGER NOT NULL AUTO_INCREMENT,
	COD_CCF VARCHAR(15),
	NOMBRE VARCHAR(128) NOT NULL,
	ES_VIGENTE VARCHAR(1) DEFAULT 'S',
	CONSTRAINT CCFS_PK PRIMARY KEY (ID_CCF)
);

