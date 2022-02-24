<template>
  <div class="col-12">
    <form class="form-inline">
      <div class="custom-control custom-checkbox my-1 mr-sm-2">
        <input
          type="checkbox"
          class="custom-control-input"
          v-bind:checked="this.checked"
          v-on:click="checkTask()"
        />
        <label class="custom-control-label mx-3" for="customControlInline">{{
          item.name
        }}</label>
        <router-link
          class="btn btn-outline-primary btn-sm my-1"
          v-bind:to="{ name: 'editor', params: { id: item.id } }"
          >Edit
        </router-link>
      </div>
    </form>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "TodoItem",
  props: {
    item: Object,
  },
  methods: {
    checkTask() {
      var checked = true;
      if (this.item.completed) {
        checked = false;
      }
      this.instance.put("/api/todo", { id: this.item.id, name: this.item.name, completed: checked })
        .then(() => console.log(this.checked = true))
        .catch((error) => console.log(error));
    },
  },
  data() {
    return {
      checked: this.item.completed,
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