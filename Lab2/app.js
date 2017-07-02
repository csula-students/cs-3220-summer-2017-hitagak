/**Lab2 JavaScript */

class Store {
    constructor(storage) {
        this.storage = storage;
        this.CART_KEY = 'CART';
        this.QUEUE_KEY = 'QUEUE';
        this.FOODS_KEY = 'FOODS';
    }


    get cartItems() {
        return JSON.parse(this.storage.getItem(this.CART_KEY));
    }


    set cartItems(cartItems) {
        this.storage.setItem(this.CART_KEY, JSON.stringify(cartItems));
    }

    get queue() {
        return JSON.parse(this.storage.getItem(this.QUEUE_KEY));
    }

    set queue(queue) {
        this.storage.setItem(this.QUEUE_KEY, JSON.stringify(queue));
    }

    get foods() {
        return JSON.parse(this.storage.getItem(this.FOODS_KEY));
    }

    set foods(foods) {
        this.storage.setItem(this.FOODS_KEY, JSON.stringify(foods));
    }
}

class Cart {

    constructor(root, store) {
        this.root = root;
        this.store = store;
        this.items = this.store.cartItems;
        this.init();
        this.confirm_order = false;
    }

    init() {

        this.render();

    }


    destroy() {

        let removeButtons = document.querySelectorAll('.remove_button');
        for (var i = 0; i < removeButtons.length; i++) {
            let btn = removeButtons[i];
            btn.removeEventListener('click', () => {
                let item = this.items[parseInt(btn.dataset.index)];
                this.removeMenu(item);
            });
        }

        let removeAllButton = document.querySelector('.remove_all_button');
        removeAllButton.removeEventListener('click', () => {
            this.removeAllItems();
        });

        let confirm_Order_Button = document.querySelector('.confirm_order_button');
        confirm_Order_Button.removeEventListener('click', () => {
            this.placeOrder();
        });
    }


    removeMenu(item) {

        if (this.items != null) {
            var updated_menu = [];
            var to_compare = item[0];
            for (var i = 0; i < this.items.length; i++) {
                if (this.items[i][0] != to_compare) {
                    updated_menu.push(this.items[i]);
                }
            }
            this.store.cartItems = updated_menu;
            this.items = updated_menu;
        }
        this.render();
    }

    removeAllItems() {
        this.store.cartItems = [];
        this.items = [];
        this.render();
    }

    placeOrder() {

        if (this.items !== null) {
            var newMenus = [];


            if (this.store.queue !== null) {
                for (var i = 0; i < this.store.queue.length; i++) {
                    newMenus.push(this.store.queue[i]);
                }
            }

            for (var i = 0; i < this.items.length; i++) {
                var new_item_added = true;
                for (var j = 0; j < newMenus.length; j++) {
                    var new_menu = newMenus[j][0];
                    if (this.items[i][0] === new_menu) {
                        var menus_to_add = Number(this.items[i][2]);
                        newMenus[j][2] += menus_to_add;
                        new_item_added = false;
                    }
                }
                if (new_item_added) {
                    newMenus.push([this.items[i][0], this.items[i][1], Number(this.items[i][2])]);
                }
            }
            this.store.queue = newMenus;
            this.confirm_order = true;
            this.removeAllItems();
        }
    }


    render() {
        this.items = this.store.cartItems;
        let tbody = this.root.querySelector('tbody');

        tbody.innerHTML = ``;
        if (this.items === null) {
            this.items = [];
        } else if ((this.items.length == 0) && (this.confirm_order)) {
            tbody.innerHTML +=
                `<tr class="cart-table">
                <td class="cart-table">
                    <p class="title">Thank you for your order</p>
                    <p>You can check your status <a href="index.html" class="link">here</a>.</p>
                </td>
            </tr>`;
            this.confirm_order = false;
            return;
        } else if (this.items.length == 0) {
            tbody.innerHTML +=
                `<tr class="cart-table">
                <td class="cart-table">
                    <p>You do not order yet</p><br>
                     <p>Click <a href="menu.html" class="link">menu</a> to get your order.</p>
                </td>
            </tr>`;
            return;
        }
        for (var i = 0; i < this.items.length; i++) {

            var item_name = this.items[i][0];
            var image_name = this.items[i][1];
            var item_quantity = Number(this.items[i][2]);

            tbody.innerHTML +=
                `<tr class="cart-table">
                    <td class="cart-table">
                        <h4>${item_name}</h4>
                        <img src=${image_name} width= 300 height= 200 class="small">
                    </td>
                    <td class="cart-table">
                        <h4>${item_quantity}</h4>
                    </td>
                    <td class="cart-table">
                        <button class="remove_button" data-name=${item_name} data-index=${i}>Remove Order</button>
                    </td>
                </tr>`;
        }

        tbody.innerHTML +=
            `<tr class="cart-table">
                <td class="cart-table" colspan="3">
                    <button class="remove_all_button">Delete Your Orders</button>
                    <br><br>
                    <button class="confirm_order_button">Confirm Your order</button>
                </td>
            </tr>`;

        let removeButtons = document.querySelectorAll('.remove_button');
        for (var i = 0; i < removeButtons.length; i++) {
            let btn = removeButtons[i];
            btn.addEventListener('click', () => {
                let item = this.items[parseInt(btn.dataset.index)];
                this.removeMenu(item);
            });
        }

        let removeAllButton = document.querySelector('.remove_all_button');
        removeAllButton.addEventListener('click', () => {
            this.removeAllItems();
        });

        let confirm_OrderButton = document.querySelector('.confirm_order_button');
        confirm_OrderButton.addEventListener('click', () => {
            this.placeOrder();
        });
    }
}

class CheckoutButton {
    constructor(root, store, cart) {
        this.root = root;
        this.store = store;
        this.onClick = () => this.addItemToCart();
        this.init();
        this.cart = cart;
    }

    init() {
        this.root.addEventListener("click", this.onClick);
    }

    destroy() {
        this.root.removeEventListener("click", this.onClick);
    }

    addItemToCart() {

        let cartItems = this.store.cartItems || [];

        var new_cart_item = true;
        for (var i = 0; i < cartItems.length; i++) {


            var selected_menu = cartItems[i][0];
            if (this.root.dataset.name === selected_menu) {
                var amount_to_add = Number(this.root.dataset.quantity);
                cartItems[i][2] += amount_to_add;
                new_cart_item = false;
            }
        }
        if (new_cart_item) {
            cartItems.push([this.root.dataset.name, this.root.dataset.image, Number(this.root.dataset.quantity)]);
        }

        this.store.cartItems = cartItems;
        this.cart.render();
    }
}

class StatusTable {

    constructor(root, store) {
        this.root = root;
        this.store = store;
        this.init();
    }

    init() {

        this.render();

    }

    destroy() {

        let clearHistoryButton = document.querySelector('.removeorder_button');
        clearHistoryButton.removeEventListener('click', () => {
            this.clearHistory();
        });
    }

    sort(columnName) {

        render();
    }



    render() {
        let tbody = this.root.querySelector('tbody');

        tbody.innerHTML = ``;
        if (this.store.queue === null) {
            this.store.queue = [];
        }
        if (this.store.queue.length == 0) {
            tbody.innerHTML +=
                `<tr class="order_status">
                <td class="order_status" >                 
                    You have no order status </p>You can buy food from <a href="menu.html" class="link">Menu </a> 
                    
                </td>
            </tr>`;
            return;
        }

        tbody.innerHTML +=
            `<tr class="order_status">
            <td class="order_status"><p><b>Created</b></p></td>
                <td class="order_status"><p><b>Item</b></p></td>
                <td class="order_status"><p><b>Quantity</b></p></td>
                <td class="order_status"><p><b>Status</b></p></td>
            </tr>`;

        for (var i = 0; i < this.store.queue.length; i++) {

            var item_name = this.store.queue[i][0];
            var image_name = this.store.queue[i][1];
            var item_quantity = Number(this.store.queue[i][2]);
            var current_date = new Date();

            tbody.innerHTML +=
                `<tr class="order_status">
                 <td class="order_status">
                        <h4>${current_date}</h4>
                        
                    </td>
                    <td class="order_status">
                        <h4>${item_name}</h4>
                        <img src=${image_name} width= 200 height= 100>
                    </td>
                    <td class="order_status">
                        <h4>${item_quantity}</h4>
                    </td>
                    <td class="order_status">
                        <h4>In Progress</h4>
                    </td>
                </tr>`;
        }

        tbody.innerHTML +=
            `<tr class="cart-table">
                <td class="cart-table" colspan="4">
                    <button class="removeorder_button">Clear All Order Status</button>             
                </td>
            </tr>`;

        let clearHistoryButton = document.querySelector('.removeorder_button');
        clearHistoryButton.addEventListener('click', () => {
            this.clearHistory();
        });

    }
    clearHistory() {
        this.store.queue = [];
        this.render();
    }

}









/** Homework 1 Javascript*/

class Inventory {
    constructor(root, store) {
        this.root = root;
        this.store = store;
        this.init();
    }

    init() {
        this.render();


    }

    destroy() {

        let defaultMenuButton = document.querySelector('.inventory_add_default_button');
        if (defaultMenuButton) {
            defaultMenuButton.removeEventListener("click", () => {
                this.addDefaultMenu();
            });
        }

        let removeMenuButton = document.querySelectorAll('.remove_inventory_button');
        for (var i = 0; i < removeMenuButton.length; i++) {
            let btn = removeMenuButton[i];
            btn.removeEventListener('click', () => {
                let item = this.store.foods[parseInt(btn.dataset.index)];
                this.removeMenu(item);
            });
        }
    }

    removeMenu(itemName) {

        if (this.store.foods !== null) {
            var updated_menu = [];
            var to_compare = itemName.name;
            for (var i = 0; i < this.store.foods.length; i++) {
                if (this.store.foods[i].name !== to_compare) {
                    updated_menu.push(this.store.foods[i]);
                }
            }
            this.store.foods = updated_menu;
        }
        this.render();
    }

    addDefaultMenu() {
        let foods = this.store.foods || [];

        var Grilled_Chicken = { name: "Grilled Chicken", image: "Picture/grilledchicken.jpg", description: "Grilled Chiken, french fries, and Fresh Vegetables" };
        var Cram_Chawder = { name: "Cram Chawder", image: "Picture/cram_chawder.jpg", description: "Hot Cram Chawder with bacon and cheese" };
        var Hot_Coffee = { name: "Hot Coffee", image: "Picture/hot_coffee.jpg", description: "Fresh Hot Coffee" };

        var updated_item_list = [Grilled_Chicken, Cram_Chawder, Hot_Coffee];

        var isnewfood = true;
        for (var i = 0; i < foods.length; i++) {
            var isnewfood = true;
            for (var j = 0; j < updated_item_list.length; j++) {
                if (foods[i].name === updated_item_list[j].name) {
                    isnewfood = false;
                    break;
                }
            }
            if (isnewfood) {
                updated_item_list.push(foods[i]);
            }
        }
        this.store.foods = updated_item_list;
        this.render();
    }

    render() {

        let tbody = this.root.querySelector('tbody');

        tbody.innerHTML = ``;

        if (this.store.foods === null) {
            this.store.foods = [];
        }

        for (var i = 0; i < this.store.foods.length; i++) {

            var food_name = this.store.foods[i].name;
            var food_image = this.store.foods[i].image;
            var food_description = this.store.foods[i].description;

            tbody.innerHTML +=
                `<tr class="horizontal">
                    <td class="horizontal"><h3>${food_name}</h3>
                        <img class="small" width= 300 height = 200 src=${food_image} >
                    </td>
                    <td><p>${food_description}</p>
                    </td>
                    <td class="horizontal">
                        <button class="remove_inventory_button" data-index=${i}>Delete</button>
                     </td>
                  </tr>`;
        }

        tbody.innerHTML +=
            `
        <tr class="horizontal">
            <td class="horizontal" colspan="3">
                <button class="inventory_add_default_button">Recovery Default Menu</button>
            </td>
        </tr>
       
        `;

        let defaultMenuButton = document.querySelector('.inventory_add_default_button');
        if (defaultMenuButton) {
            defaultMenuButton.addEventListener("click", () => {
                this.addDefaultMenu();
            });
        }

        let removeMenuButton = document.querySelectorAll('.remove_inventory_button');
        for (var i = 0; i < removeMenuButton.length; i++) {
            let btn = removeMenuButton[i];
            btn.addEventListener('click', () => {
                let item = this.store.foods[parseInt(btn.dataset.index)];
                this.removeMenu(item);
            });
        }
    }
}

class Menu {
    constructor(root, store, cart) {
        this.root = root;
        this.store = store;
        this.cart = cart;
        this.init();
    }

    init() {
        this.render();
    }

    render() {

        let tbody = this.root.querySelector('tbody');

        for (var i = 0; i < this.store.foods.length; i++) {

            var food_name = this.store.foods[i].name;
            var food_image = this.store.foods[i].image;
            if (food_image.startsWith("../")) {
                food_image = food_image.slice(3);
            }
            var food_description = this.store.foods[i].description;

            tbody.innerHTML +=
                `<tr class="horizontal">
                    <td class="horizontal menu1"><h3>${food_name}</h3></td>
                    <td class="horizontal menu2"><img class="medium" width=300 height= 200 src=${food_image} >
                    </td>
                    <td class="horizontal menu3"><p>${food_description}</p>
                    </td>
                    <td class="horizontal menu4">
                        <button class="checkout-button" data-name="${food_name}" data-image="${food_image}" data-quantity=1>Order this item</button>
                     </td>
                  </tr>`;
        }

        let checkoutButtons = document.querySelectorAll('.checkout-button');
        if (checkoutButtons && checkoutButtons.length) {
            for (var i = 0; i < checkoutButtons.length; i++) {
                new CheckoutButton(checkoutButtons[i], this.store, this.cart);
            }
        }
    }
}

class CreateFood {
    constructor(root, store) {
        this.root = root;
        this.store = store;
        this.init();
    }

    init() {

        let addMenuButton = document.getElementById('add_menu_button');
        if (addMenuButton) {
            addMenuButton.addEventListener("click", () => {
                this.createFood();
            });
        }
       
    }

    createFood() {

        let foods = this.store.foods || [];
        var food_name = document.getElementById('food_name').value;
        var food_image = document.getElementById('food_image').value;
        var food_description = document.getElementById('food_description').value;
        var to_push = { name: food_name, image: food_image, description: food_description };

        if (window.confirm("Do you want to add this menu?") == true) {


            var isnewfood = true;
            for (var i = 0; i < foods.length; i++) {
                if (to_push.name === foods[i].name) {
                    isnewfood = false;
                    break;
                }
            }
            if (isnewfood) {
                foods.push(to_push);
                this.store.foods = foods;
               
            }
        }
    }
}


document.addEventListener('DOMContentLoaded', () => {

    let statusTable = document.querySelector('.order_status');

    let cart = document.querySelector('.cart-table');
    let checkoutButtons = document.querySelectorAll('.checkout-button');


    let createFood = document.querySelector('#create_menu');
    let inventory = document.querySelector('#inventory_table');
    let menu = document.querySelector('#menutable');

    let store = new Store(window.localStorage);

    if (statusTable) {
        new StatusTable(statusTable, store);
    }
    if (cart) {
        var cartVar = new Cart(cart, store);
    }
    if (checkoutButtons && checkoutButtons.length) {
        for (var i = 0; i < checkoutButtons.length; i++) {
            new CheckoutButton(checkoutButtons[i], store, cartVar);
        }
    }

    if (createFood) {
        new CreateFood(createFood, store);
    }
    if (inventory) {
        new Inventory(inventory, store);
    }
    if (menu) {
        new Menu(menu, store, cartVar);
    }
});