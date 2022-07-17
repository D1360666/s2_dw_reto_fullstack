const d = document,
$txtLista = d.getElementById("txtLista"),
$btnCrearLista = d.getElementById("btnCrearLista"),
$btnCargarListas = d.getElementById("btnCargarListas"),
$artIngreso = d.getElementById("ingreso")
let nameList


$btnCrearLista.addEventListener("click", async e =>{
    
    if($txtLista.value==''){
        alert("No ha ingresado nombre de lista")
    }else{
        nameList=$txtLista.value
        try{
            let options = {
                method:"POST",
                headers:{
                    "Content-type":"application/json; charset=utf-8"
                },
                body: JSON.stringify({
                    name: nameList
                })
            },
            res= await fetch("http://localhost:8080/listas", options),
            json = await res.json()

            console.log(json)
            alert("Lista registrada \n" + json.name)

            if(!res.ok)throw {status: res.status, statusText: res.statusText}

        }catch(err){
            let message = err.statusText || "Ocurrió un error"
            console.log(message)
            $artIngreso.insertAdjacentHTML("afterend", `<p><b>Error ${err.status}: ${message}</b></p>`)
        }
    }
})
