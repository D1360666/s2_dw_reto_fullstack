export default class TaskList{
    cosntructor(id, name, tasks){
        this.id = id;
        this.name = name;
        this.tasks = tasks;
    }
    get getId(){
        return this.id;
    }
    get getName(){
        return this.name;
    }
    get getTasks(){
        return this.tasks
    }

    set setId(id){
        this.id = id;
    }
    set setName(name){
        this.name = name;
    }
    set setTasks(tasks){
        this.tasks = tasks;
    }
}