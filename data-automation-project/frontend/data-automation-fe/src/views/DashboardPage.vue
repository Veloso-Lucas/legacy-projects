<template>
    <div class="dashboard-page">
      <h1>Welcome to the Dashboard!</h1>
      <button @click="logout">Logout</button>
    </div>
  </template>
  
  <script>
  export default {
    methods: {
      logout() {
        // Remove o token de autenticação e redireciona para a página de login
        localStorage.removeItem('auth-token');
        this.$router.push('/');
      },
    },
  };
  </script>
  
  <style scoped>
  .dashboard-page {
    text-align: center;
    margin-top: 50px;
  }
  </style>
  