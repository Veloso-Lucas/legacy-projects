import { createRouter, createWebHistory } from 'vue-router';
import LoginPage from '@/views/LoginPage.vue';
import DashboardPage from '@/views/DashboardPage.vue';

const routes = [
  {
    path: '/',
    name: 'HomeLogin',
    component: LoginPage,
  },
  {
    path: '/login',
    name: 'Login',
    component: LoginPage,
  },
  {
    path: '/dashboard',
    name: 'Dashboard',
    component: DashboardPage,
    requiresAuth: true
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

// Checks that the user is authenticated before accessing protected routes
router.beforeEach((to, from, next) => {
  if (to.requiresAuth && !localStorage.getItem('auth-token')) {
    next('/');
  } else {
    next();
  }
});

export default router;
