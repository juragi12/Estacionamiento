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
      <tr v-for='(sitioParqueo, key) in listaVehiculosParqueados' :key='key' @click='vehiculoSeleccionado(sitioParqueo)' >
        <th scope="row">{{ key+1 }}</th>
        <td>{{ sitioParqueo.vehiculo.placa }}</td>
        <td>{{ sitioParqueo.vehiculo.tipo }}</td>
        <td>{{ sitioParqueo.fechaInicio |moment("dddd, MMMM Do YYYY, h:mm:ss a")  }}</td>
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

    vehiculoSeleccionado(sitioParqueo) {
      console.log("tabla tipo vehiculo",sitioParqueo.vehiculo.tipo),

      this.vehiculo.placa = sitioParqueo.vehiculo.placa,
      this.vehiculo.tipo = sitioParqueo.vehiculo.tipo,
      this.vehiculo.cilindraje = sitioParqueo.vehiculo.cilindraje,

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
