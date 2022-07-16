//import {Task} from 'task.js'

//Declaracion de variables
const d = document,
    $title = d.querySelector("nombre-lista"),
    $crear = d.getElementById("crear"),
    body = d.querySelector('.tbody1'),
    $input = d.getElementById('inputTarea').value,
    $template = d.querySelector("crud-template"),
    $table = d.querySelector(".crud-table"),
    $fragment = d.createDocumentFragment()

    $crear.addEventListener("click", () => {
        $fragment.appendChild($template)
       // let tks = new task();
        
    })