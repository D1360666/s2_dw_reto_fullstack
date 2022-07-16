export default class Task{
    constructor(id, tarea, completado){
        this.id = id;
        this.tarea = tarea,
        this.completado = completado
    }
    
    get getId(){
        return this.id;
    }
    get getTarea(){
        return this.tarea;
    }
    get getCompletado(){
        return this.completado
    }

    set setId(id){
        this.id = id;
    }
    set setTarea(tarea){
        this.tarea = tarea;
    }
    set setCompletado(completado){
        this.completado = completado;
    }

}
