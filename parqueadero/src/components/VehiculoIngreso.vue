<template>

<div id="vehiculoingreso">

  <!-- Formulario de ingreso de vehiculo -->
  <div>
    <div class="jumbotron">
      <h1 class="display-7">Ingreso de vehiculos</h1>
      <div class="form-row">
        <div class="form-group col-md-4">
          <label for="inputPlaca">Placa vehiculo</label>
          <input type="text" class="form-control" v-model= 'vehiculo.placa' >
        </div>
        <div class="form-group col-md-4">
          <label for="inputTipo">Tipo de vehiculo</label>
          <select  class="form-control"
            @change='tipoSeleccionado()'
            v-model='vehiculo.tipo'>
              <option v-for='tipo in tipoVehiculo'
              >
                {{ tipo }}
              </option>
          </select>
        </div>
        <div class="form-group col-md-4">
          <label for="inputCilindraje">Cilindraje</label>
          <input type="text" class="form-control" v-model='vehiculo.cilindraje' >
        </div>
      </div>

      <button type="submit"
        class="btn btn-success col-md-3"
        @click='registrarIngresoVehiculo()'>
        Ingresa
      </button>

    </div>

  </div>

</div>
</template>

<script>
import axios from 'axios'
import Propiedades from '@/helpers/Propiedades'

export default {
  name: 'VehiculoIngreso',
  data () {
    return {
      vehiculo: {
        placa: null,
        cilindraje: 250,
        tipo: "MOTO",
      },
      tipoVehiculo: [ "MOTO", "CARRO" ],
      tipoSelec: "MOTO",
      msg: 'Estacionamiento Ceiba VehiculoIngreso',
      respuesta: null
    }
  },

  methods: {

    tipoSeleccionado () {
      console.log('Prop changed: ', this.vehiculo.tipo)
      //this.vehiculo.tipo = this.tipoSelec
    },

    registrarIngresoVehiculo () {
      axios.post( Propiedades.BASE_URL+'registraringreso', this.vehiculo )
      .then((response) => {
        this.respuesta = response.data
        // Emite evento a parents informando que se realizo un ingreso de vehiculo
        this.$emit('oningresovehiculo');
      })
      .catch((error) => {
        this.$emit('onerrormensaje', error.response.data)
      })
    }
  }
}

</script>

<style>
#vehiculoingreso {
  margin-top: 60px
}
</style>
