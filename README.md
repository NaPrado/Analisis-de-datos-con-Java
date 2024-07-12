# Analisis de datos con Java
## Idea del proyecto
Basándose en la consigna de este cuatrimestre del final de Programación Imperativa, tome la decisión de aprender a manejar archivos csv en java y de paso el uso de streams. Además implemente una pequeña interfaz graficá para que el analisis sea más practíco y comodo para el usuario. 

[Dejo adjunta la consiga del tp](https://docs.google.com/document/d/1FJQEpgz-SfFo9r5GgsGiFVnENPiqqJ279xLvjOTpMHY/edit)
[Dejo los archivos para descargar](https://drive.google.com/drive/folders/1qA3C5qVyNsPWFohMxiwXr6_-AmLsa0Qk)

Tenes que ser del ITBA para poder verlos, pero dejo un pequeño resumen de que tratan las queries

### Query 1: Total de multas por infracción 
Donde cada línea de la salida contenga, separados por “;” el nombre de la infracción y la cantidad total de multas con esa infracción.
La información debe listarse ordenada en forma descendente por la cantidad total de multas y a igualdad de multas desempatar alfabéticamente por nombre de la infracción.

#### Ejemplo de salida:

    infraction;tickets
    PHTO SCHOOL ZN SPEED VIOLATION;24192871
    NO PARKING-STREET CLEANING;10836191
    FAIL TO DSPLY MUNI METER RECPT;8228382
    NO STANDING-DAY/TIME LIMITS;8228382
    ...
### Query 2: Infracción más popular por agencia emisora
Donde cada línea de la salida contenga, separados por “;” el nombre de la agencia emisora, la infracción más popular de esa agencia emisora y la cantidad de multas correspondiente.
La infracción más popular de una agencia emisora es la que tiene la mayor cantidad de multas. En caso de que existan dos o más infracciones con la misma cantidad de multas para la misma agencia emisora considerar la menor infracción en orden alfabético.
La información debe listarse ordenada en forma alfabética por agencia emisora.

#### Ejemplo de salida:

    issuingAgency;infraction;tickets
    AMTRAK RAILROAD POLICE;NO STANDING-EXC. AUTH. VEHICLE;61
    BOARD OF ESTIMATE;DOUBLE PARKING;182
    DEPARTMENT OF BUSINESS SERVICES;NO PARKING-DAY/TIME LIMITS;23
    DEPARTMENT OF CORRECTION;BEYOND MARKED SPACE;105
    ...
### Query 3: Patente con más multas por infracción
Donde cada línea de la salida contenga, separados por “;” el nombre de la infracción, la patente con la mayor cantidad de multas de esa infracción y la cantidad de multas.
En caso de que existan dos o más patentes con la misma cantidad de multas para la misma infracción considerar la menor patente en orden alfabético.
La información debe listarse ordenada en forma alfabética por infracción. 

#### Ejemplo de salida:

    infraction;plate;tickets
    ANGLE PARKING;FBG7141;38
    BEYOND MARKED SPACE;52966MD;119
    BIKE LANE;MH83485;1654
    BUS LANE VIOLATION;AY860L;119
    ...
> [!NOTE]
> Para las siguientes queries deben recibir adicionalmente hasta dos parámetros adicionales indicando un rango de años. Las queries 4 y 5 deberán considerar únicamente las multas que tengan una fecha dentro de ese rango. 
### Query 4: Top 3 meses con más multas por año
Donde cada línea de la salida contenga, separados por “;” el año, el mes con la mayor cantidad de multas en el año, el mes con la segunda mayor cantidad de multas en el año y el mes con la tercer mayor cantidad de multas en el año.
La información debe listarse ordenada en forma cronológica por año.
En caso de que existan dos o más meses con la misma cantidad de multas para ese año considerar el menor de los meses (orden cronológico). Por ejemplo, si dos meses Marzo y Septiembre comparten el primer puesto entonces Marzo ocupará el primer puesto y Septiembre el segundo. Si dos meses Abril y Octubre comparten el tercer puesto entonces Abril ocupará el tercer puesto y Octubre no se listará. En caso de que para un año no existan multas de al menos tres meses distintos mostrar un “Empty” donde se espera un mes.

#### Ejemplo de salida:

    year;ticketsTop1Month;ticketsTop2Month;ticketsTop3Month
    2020;July;March;April
    2021;July;April;March
    2022;December;July;March
    2023;August;July;December
    ...
### Query 5: Montos mínimos y máximos por infracción
Donde cada línea de la salida contenga, separados por “;” el nombre de la infracción, el monto mínimo (el menor monto de todas las multas con esa infracción), el monto máximo (el mayor monto de todas las multas con esa infracción) y la diferencia entre ambos montos (la resta entre máximo y mínimo).
La información debe listarse ordenada en forma descendente por diferencia entre ambos montos y a igualdad de diferencia desempata alfabéticamente por nombre de infracción.

#### Ejemplo de salida:

    infraction;minAmount;maxAmount;diffAmount
    PEDESTRIAN RAMP;35;650;615
    ALTERING INTERCITY BUS PERMIT;9;604;595
    BLUE ZONE;29;624;595
    SIDEWALK;0;500;500
    ...
