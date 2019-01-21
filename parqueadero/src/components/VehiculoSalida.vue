<template>

<div>

  <div>

    <div class="jumbotron">
      <h1 class="display-7">Salida de vehiculos</h1>

      <div class="row">

        <div class="form-group col-md-6">
          <label for="inputCity">Placa</label>
          <input type="text" class="form-control" v-model= 'vehiculoSalida.placa' readonly>
        </div>

        <div class="form-group col-md-6">
          <label for="inputCity">
            <h4>
              Precio:
            </h4>
            <h2>
              {{ this.precio }}
            </h2>
          </label>
        </div>

      </div>

      <button type="submit"
        class="btn btn-warning col-md-3"
        @click='registrarSalidaVehiculo()'>
        Sale
      </button>

    </div>

  </div>
</div>
</template>


<script>
import axios from 'axios'
import Propiedades from '@/helpers/Propiedades'

export default {
  name: 'VehiculoSalida',
  props: ['vehiculoSalida'],
  data () {
    return {
      precio: 0,
      msg: 'Welcome Estacionamiento Ceiba VehiculoSalida'
    }
  },

  methods: {
    registrarSalidaVehiculo () {

      console.log("Precio: ",this.vehiculoSalida);

      axios.post( Propiedades.BASE_URL+'registrarsalida', this.vehiculoSalida )
      .then((response) => {
        this.respuesta = response.data,
        this.precio = response.data;
        console.log("Precio: ",this.precio);
        // Emite evento a parents informando que se realizo una salida de vehiculo
        this.$emit('onsalidavehiculo');

      })
      .catch((error) => {
        console.error(error)
      })
    }
  }
}
</script>
