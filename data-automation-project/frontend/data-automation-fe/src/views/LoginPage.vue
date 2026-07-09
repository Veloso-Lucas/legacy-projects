<template>
    <div class="login-page">
      <LoginForm :loginUser="loginUser" />
    </div>
  </template>
  
<script>
  import LoginForm from '@/components/LoginForm.vue'; // Importa o componente de login
  
  export default {
    components: {
      LoginForm,
    },
    methods: {
      async loginUser(username, password) {
        // Lógica para autenticar o usuário via API
        try {
          const response = await this.$axios.post('/api/login', {
            username,
            password,
          });
  
          // Armazena o token de autenticação no localStorage
          localStorage.setItem('auth-token', response.data.token);
  
          // Redireciona para a página do Dashboard após o login bem-sucedido
          this.$router.push('/dashboard');
        } catch (error) {
          throw new Error('Invalid username or password');
        }
      },
    },
  };
  </script>
  
  <style scoped>
  .login-page {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
  }
  </style>
  