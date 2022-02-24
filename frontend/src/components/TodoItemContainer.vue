<template>
  <div class="container">
    <div class="row my-4">
      <div class="col-12">
        <h1 class="h1">Todo List</h1>
      </div>
    </div>
    <div class="row" v-for="item in items" v-bind:key="item.id">
      <TodoItem v-bind:item="item"></TodoItem>
    </div>
    <div class="row mt-4">
      <div class="col-12">
        <form class="form-inline d-flex mb-5" @submit.prevent="addTask" >
          <input
            type="text"
            class="form-control w-25 input-sm"
            placeholder="New Task"
            v-model="name"
          />
          <button type="submit" class="btn btn-primary mx-3">Add</button>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import TodoItem from "./TodoItem.vue";

export default {
  name: "TodoItemContainer",
  components: {
    TodoItem,
  },
  beforeMount() {
    this.getAllItems()
  },
  methods: {
    addTask() {
      this.instance
        .post("/api/todo", { name: this.name, completed: false })
        .then((response) => {
          this.items.push({
            id: response.data.id,
            name: response.data.name,
            checked: response.data.completed,
          });
        })
        .catch((error) => console.log(error));
        this.$router.go("/");
    },
    getAllItems() {
      this.instance
        .get("/api/todo")
        .then((response) => {
          if(this.items != null){
            this.items = this.items.concat(response.data);
          }
          else{
            this.items = response.data;
          }
          
        }
        )
        .catch((error) => console.log(error));
    },
  },
  data() {
    return {
      info: null,
      items: [
      ],
      instance: axios.create({
        headers: {
          "Access-Control-Allow-Origin": "*",
        },
        baseURL: "http://localhost:8080",
      }),
    };
  },
};
</script>