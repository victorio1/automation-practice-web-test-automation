Feature: Busqueda de Productos

  Esta caracteristica permite a los clientes realizar
  busquedas de productos que desean comprar en la
  tienda virtual Eduardo.
  Se presenta informacion como precio, stock, valores

  Scenario: Busqueda exitosa de un producto
  Este escenario consiste en realizar una busqueda
  que retorna al menos un producto como resultado

    Given El cliente se encuentra en la pagina de busqueda
    When realiza la busqueda de productos con el termino "blouse"
    And cambia la visualizacion de resultados a modo lista
    Then se muestra el producto con el precio "$50.00"