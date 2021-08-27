# Microservicio - ms-exercise-one

Es responsable de mantener los ítems (inventario) del sitio e-commerce de una reconocida empresa.

1. [Ownership](/readme.md#1-ownership)
2. [Operaciones](/readme.md#2-operaciones)
3. [Especificación Técnica](/readme.md#3-especificaci%C3%B3n-t%C3%A9cnica)
4. [Dependencias](/readme.md#4-ejecuci%C3%B3n)
5. [Eventos](/readme.md#5-eventos)
6. [Ciclo de Vida](/readme.md#6-ciclo-de-vida)
7. [Change Log](/readme.md#7-change-log)

## 1. Ownership
Eduar Alexis Peña velasco.

### 1.1. Business Owner
Nisum

### 1.2. Technical Owner
Nisum training

## 2. Operaciones
Detalla las operaciones que se pueden explotar a través del microservicio. 

| Operación | Descripción Capacidad |

| Adicionar item | Se crea un nuevo Item |

## 3. Especificación Técnica
Detalle técnico del microservicio provisto por especificación Swagger.

<URL a especificación Swagger>
  
## 4. Dependencias
Este microservicio se envía eventos al topic "items-update" kafka

### 4.1. Microservicios

| Dependencia | Descripción de la dependencia | Operación |

### 4.2. Repositorio de Datos

| Repositorio| Descripción |

| PostgreSQL | Base de Datos permite almacenar la información derefente a los item creados  |

### 4.3. Backends

| Dependencia | Descripción de la dependencia | Operación |

| ------  | ------  | ------  |

## 5. Eventos
En esta sección se especifican los eventos que utiliza el microservicio como parte su lógica de negocio.
| Evento | Descripción | publicador/suscriptor |

| Produce un evento  | Envia descripción de si un item fue creado o actualizado con su respectivo id. | publicador  |

## 6. Ciclo de Vida
En esta sección se especifica el procedimiento para disponibilizar el microservicio.

### 6.1. Compilación
Detalla la forma en que el microservicio debe ser compilado:

./gradlew build

### 6.2. Configuraciones
Detalla las configuraciones necesarias para que el microservicio pueda operar:

#### 6.2.1. Propiedades
| Clave | Valor | Responsable Integracion | Responsable QA | Responsable Produccion |

| spring.aplication.name | ms-second_checlpoint-exercise-one | Eduar | Eduar | Eduar |

#### 6.2.2. Secretos
| Clave | Valor | Responsable Integracion | Responsable QA | Responsable Produccion |

| ------  | ------ | ------ | ------ | ------ |

### 6.3. Ejecución

#### 6.3.1. Contenedor
Especifica la forma en que se ejecuta la aplicación en un contenedor docker:

docker run -e SPRING_PROFILES_ACTIVE='<ambiente>' -e CONTEXT_PATH='/operaciones-transversales-de-producto/gestion-de-cuenta/ms-cuentaspyme-neg/<MS_VERSION>' -e SPRING_CLOUD_CONFIG_URI='http://config-server-service.bci-infra:8888' -e VAULT_SCHEME='https' -e VAULT_HOST='vault-server-service.bci-infra' -e VAULT_PORT='8200' -e VAULT_TOKEN='<VAULT_TOKEN>' -e VAULT_AUTHENTICATION='TOKEN' -e VAULT_TRUST_STORE='file:/vol-ms/pubcerts.ts' -e VAULT_TRUST_STORE_PWD='<VAULT_TRUST_STORE_PWD>' -e MS_VERSION='<MS_VERSION>'  -p 8080:8080 --name=ms-cuentaspyme-neg registry.ng.bluemix.net/reg_ic/ ms-cuentaspyme-neg:<MS_VERSION>

Descripción de variables de entorno:
* SPRING_PROFILES_ACTIVE: <Descripción>

#### 6.3.2. Recursos Utilizados
Detalla los recursos utilizados por una instancia de un contenedor docker.

| Recurso | Requerido |

| ------ | ------ |

| CPU | Detallar cuánto recurso de CPU se debería destinar a una instancia de microsevicio |
| Memoria | Detallar cuánto recurso de Memoria se debería destinar a una instancia de microsevicio |
| Storage | Detallar cuánto almacenamiento se debería reservar para una instancia de microsevicio |
| Throughput| Detallar cuántos usuarios concurrentes permiten la especificación de recursos descrita anteriormente |


## 7. Change Log

### Versión 1.0.0 (23/08/2021)
 - Creación del microservicio 
 - Se crea endpoint para crear y actualizar items de un inventario

