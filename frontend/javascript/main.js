let counter = 0;
function increment() {
    counter++;
    displayCounterToUI();
}

function decrement() {
    counter--;
    displayCounterToUI();
}

function displayCounterToUI() {
    let ele = document.getElementById("A");
    //to add the content we will use innerHTML property
    ele.innerHTML = "Counter=" + counter;
    //<div id="A">Counter= CounterValue</div>
}



