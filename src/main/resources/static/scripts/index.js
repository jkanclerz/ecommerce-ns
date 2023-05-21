const getProducts = () => {
    return fetch("/api/products")
        .then(res => res.json());
}

const  getProductsV2 = async () => {
    const response =  await fetch("/api/products");
    const products =  await response.json();

    return products;
}

(() => {
    alert("it works");
})();