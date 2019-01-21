<template>

<div>

  <h2>Lista de vehiculos en el estacionamiento</h2>

  <table class="table table-dark">
    <thead>
      <tr>
        <th scope="col">#</th>
        <th scope="col">Placa</th>
        <th scope="col">Tipo Vehiculo</th>
        <th scope="col">Fecha de inicio</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for='(vehiculo, key) in listaVehiculosParqueados' :key='key' @click='vehiculoSeleccionado(vehiculo)' >
        <th scope="row">{{ key+1 }}</th>
        <td>{{ vehiculo.placa }}</td>
        <td>{{ vehiculo.tipo }}</td>
        <td>{{ vehiculo.fechaInicio |moment("dddd, MMMM Do YYYY, h:mm:ss a")  }}</td>
      </tr>
    </tbody>
  </table>


  <button type="submit"
    class="btn btn-primary col-md-3"
    @click='obtenerVehiculosParqueados()'>
    Consultar
  </button>

</div>


</template>


<script>

import axios from 'axios'
import Propiedades from '@/helpers/Propiedades'



export default {
  name: 'VehiculosTabla',
  props: ['actualizarTabla'],
  data () {
    return {
      vehiculo: {
        placa: "",
        cilindraje: 0,
        tipo: "",
      },
      listaVehiculosParqueados: []
    }
  },

  mounted () {
    this.obtenerVehiculosParqueados();
  },

  watch: {
    actualizarTabla: function (newVal, oldVal) {
      //console.log('Prop changed: ', newVal, ' | was: ', oldVal),
      if (newVal){
        this.obtenerVehiculosParqueados()
      }
    },
  },

  methods: {

    vehiculoSeleccionado(vehiculo) {
      console.log("tabla tipo vehiculo",vehiculo.tipo),

      this.vehiculo.placa = vehiculo.placa,
      this.vehiculo.tipo = vehiculo.tipo,

      this.$emit('onvehiculoseleccionado', this.vehiculo)
    },

    obtenerVehiculosParqueados () {
      axios
        .get(Propiedades.BASE_URL+'consultar')
        .then(response => (
          this.listaVehiculosParqueados = response.data,
          // emite evento indicando al parent que al tabla fue actualoizada
          this.$emit('onvehiculostablaactualizada'),
          console.log("Consulta lista")
          )
        )
        .catch(error => console.log(error))
      }
  }
}
</script>
