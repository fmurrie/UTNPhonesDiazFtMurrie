Metodologia de trabajo:

->Base de datos:
-Guardar scripts en la carpeta DatabaseScripts y dentro en la carpeta que corresponda
el objeto a añadir en la base de datos.
-El nombre para el archivo debera cumplir el siguiente formato (el simbolo + es para concatenar como debe ser):
    "yyyy+mm+dd+hh+mm+nombre_objetodb"
-Programar todo en Ingles.
-Aplicar hasta donde se pueda y se permita la logica en los StoredProcedure.
-Nomenclaturas:
.Tablas: nombre plural camelcase.
    .Columnas: nombre singular camelcase.
    .Constraint:
        .Primary: PK_NombreTabla_NombreColumna.
        .Foreign: FK_NombreTabla_NombreColumna_NombreReferencia.
        .Unique: UK_NombreTabla_NombreColumna.
        .Check: CHK_NombreTabla_NombreColumna1_NombreColumna2.
.Procedure: "NombreTabla_"+"Modulo"+"lo que hace".
    .Parametros: in o out o inout "p" + nombre singular camelcase.
.Trigger: "NombreTabla_"+"Modulo""+"lo que hace".
