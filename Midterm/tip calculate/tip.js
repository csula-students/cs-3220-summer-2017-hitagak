function calc() {
    var bill = Number(document.getElementById('bill').value);
    var tip_rate = Number(document.getElementById('tip').value);
    var tip = bill * (tip_rate * 0.01);
    var total_bill = bill + tip;

    document.getElementById("tip_rate").innerHTML = "$" + Number(tip).toFixed(2);
    document.getElementById("total").innerHTML = "$" + Number(total_bill).toFixed(2);
}