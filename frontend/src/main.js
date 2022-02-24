import { createApp } from 'vue'
import { createRouter, createWebHistory } from 'vue-router'
import TodoItemContainer from './components/TodoItemContainer.vue'
import TodoItemEditor from './components/TodoItemEditor.vue'
import App from './App.vue'

const routes = [{
        path: '/',
        name: 'items',
        component: TodoItemContainer
    },
    {
        path: '/editor',
        name: 'editor',
        component: TodoItemEditor,
        props: true
    },
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

createApp(App)
    .use(router)
    .mount('#app')