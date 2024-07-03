Feature: Tienda Online

  @Validacion
  Scenario: Validar Precio del Producto
    Given estoy en la pagina de la tienda
    Then click en Iniciar Sesion
    And ingreso el usuario "jhermanfcs@hotmail.com" y contraseña "Contraseña."
    When selecciono la categoría "Clothes" y la subcategoría "Men"
    And añado 2 unidades del primer producto al carrito
    And verifico que el monto total en el popup sea calculado correctamente
    Then el monto total mostrado coincide con el precio de los productos agregados

