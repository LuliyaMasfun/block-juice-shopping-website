
        function apiConnection(){
        var xhr = new XMLHttpRequest()
        xhr.open("Get", "http://localhost:8081/product")
        xhr.onload = function(){
        var data = JSON.parse(this.response)
            createProduct(data)
            }
            xhr.send()
}

        var shoppingCart = (function() {
        private CartItem cartItem;
        private Customer customer;
        private Product product;
        }
        cart = [];

}
        function CartItem(cartItemId, quantity, product, customer) {
            this.cartItemId = cartItemId;
            this.quantity = quantity;
            this.product = product;
            this.customer = customer;

}               // Save cart
        function saveCart() {
            sessionStorage.setCartItem('shoppingCart', JSON.stringify(cart));
            sessionStorage.setCartItem('shoppingCart', JSON.stringify(cart));
              }

               // Load cart
                function loadCart() {
                  cart = JSON.parse(sessionStorage.getCartItem('shoppingCart'));
                }
                if (sessionStorage.getCartItem("shoppingCart") != null) {
                  loadCart();
                }
                 var obj = {};
          } //https://codepen.io/chrisachinga/pen/MWwrZLJ

 function removeAllProducts(){
 var getClass = document.getElementsByClassName("shop-products")
 for(var i = 0; i < getClass.length; i++){
 getClass[i].remove()
 }
 }
 removeAllProducts()

 function setProduct(){
 var getBody = document.getElementById("body")
 var createDiv = document.createElement("div")
 createDiv.setAttribute("class","shop-products")
 createDiv.setAttribute("id","shop-products")
 getBody.appendChild(createDiv)

 for(var i = 0; i < 20; i++){ //Ändra talet beroende på antalet items
 var createClass = document.createElement("div")
 createClass.setAttribute("class", "grid-item-shop")
 createClass.setAttribute("id", "item" + i)
 var getDiv = document.getElementById("shop-products")
 getDiv.appendChild(createClass)
 var createA1 = document.createElement("a") //Skapar A
 createA1.setAttribute("href", "/dress")
 createA1.setAttribute("id","img" + i) //setter attribut
 var findItem0 = document.getElementById("item" + i) //find item0
 findItem0.ap

 function removeAllProducts(){
    var getClass = document.getElementsByClassName("shop-products")
    for(var i = 0; i < getClass.length; i++){
      getClass[i].remove()
    }
  }

 removeAllProducts()

 function setProduct(){
  var getBody = document.getElementById("body")
  var createDiv = document.createElement("div")
  createDiv.setAttribute("class","shop-products")
  createDiv.setAttribute("id","shop-products")
  getBody.appendChild(createDiv)

  for(var i = 0; i < 20; i++){ //Ändra talet beroende på hur många varor du har
  var createClass = document.createElement("div")
  createClass.setAttribute("class", "grid-item-shop")
  createClass.setAttribute("id", "item" + i)

  var getDiv = document.getElementById("shop-products")
  getDiv.appendChild(createClass)

  var createA1 = document.createElement("a") //Skapar A
  createA1.setAttribute("href", "/dress")
  createA1.setAttribute("id","img" + i) //setter attribut
  var findItem0 = document.getElementById("item" + i) //find item0
  findItem0.appendChild(createA1)
  var img0 = document.createElement("img")
  img0.setAttribute("src", "/src/main/resources/static/images/productimage.jpeg")
  var findA = document.getElementById("img" + i)
  findA.appendChild(img0)

  var createA2 = document.createElement("a")
  createA2.setAttribute("href", "/dress")
  createA2.setAttribute("id" ,"item" + i)
  findItem0.appendChild(createA2)


  var createP1 = document.createElement("p")
  createP1.setAttribute("class", "item-tag-shop")
  createP1.setAttribute("id", "itemName0")
  createP1.innerHTML= "<strong>ITEM</strong>"
  var findItemPrice0 = document.getElementById("img" + i)
  findItemPrice0.appendChild(createP1)

  var createPriceTag = document.createElement("p")
  createPriceTag.setAttribute("class", "price-tag-shop")
  createPriceTag.setAttribute("id", "itemPrice0")
  createPriceTag.innerHTML="000 sek"
  findItem0.appendChild(createPriceTag)
 }
 }

 setProduct()