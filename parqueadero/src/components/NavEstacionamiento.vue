<template lang="html">

  <b-navbar
  fixed="top"
  toggleable="md" type="dark" variant="primary"
  >

    <b-navbar-toggle target="nav_collapse"></b-navbar-toggle>

    <b-navbar-brand href="#">Ceiba Estacionamiento juan.giraldo</b-navbar-brand>

    <b-collapse is-nav id="nav_collapse">


      <!-- Right aligned nav items -->
      <b-navbar-nav class="ml-auto">
        <b-nav-item-dropdown right>
        </b-nav-item-dropdown>
      </b-navbar-nav>

  </b-collapse>
  </b-navbar>

</template>

<script>
export default {
  name: 'NavEstacionamiento',
}
</script>

<style lang="css" scoped>
</style>
