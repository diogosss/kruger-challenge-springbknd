CREATE TABLE public.tests
(
    empleado_id integer NOT NULL,
    cedula integer NOT NULL,
    nombres character varying(100) COLLATE pg_catalog."default" NOT NULL,
    apellidos character varying(100) COLLATE pg_catalog."default" NOT NULL,
    correo character varying(100) COLLATE pg_catalog."default" NOT NULL,
    direccion character varying(200) COLLATE pg_catalog."default",
    telefono integer,
    estadovac boolean,
    tipovac character varying(100) COLLATE pg_catalog."default",
    nacimiento date,
    fechavacuna date,
    numdosis integer,
    CONSTRAINT tests_pkey PRIMARY KEY (empleado_id)
)