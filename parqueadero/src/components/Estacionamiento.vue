<template>

<div class="container-fluid">


        <!-- Modal Component -->
      <b-modal title="Estacionamiento Ceiba Juan RG"
        header-bg-variant = 'warning'
        v-model='modalMostrar'>
      <p class="my-4">{{this.mensajeError}}</p>
      </b-modal>

    <div class="container-fluid col-sm-12">
      <nav-estacionamiento/>
    </div>

    <div class="container-fluid" >

      <div class="container-fluid">
        <vehiculo-ingreso
          @onerrormensaje = 'errorMensaje'
          @oningresovehiculo ='actualizarListaVehiculos()'>
        </vehiculo-ingreso>

      </div>

      <div class="container-fluid">
        <div class="row">
          <div class="col-lg-8 col-sm-12">
            <vehiculos-tabla
              :actualizarTabla ='this.actualizarTabla'
              @onvehiculostablaactualizada = 'vehiculosTablaActualizada()'
              @onvehiculoseleccionado = 'vehiculoSeleccionadoTabla'>
            </vehiculos-tabla>
          </div>
          <div class="col-lg-4 col-sm-12">
            <vehiculo-salida
              :vehiculoSalida = 'this.seleccionadoEnTabla'
              @onsalidavehiculo = 'actualizarListaVehiculos()'>
            </vehiculo-salida>
          </div>
        </div>
      </div>

      <div class="container-fluid">
        <Trm/>
      </div>

    </div>

</div>

</template>

<script>
import NavEstacionamiento from '@/components/NavEstacionamiento'
import VehiculoIngreso from '@/components/VehiculoIngreso'
import VehiculoSalida from '@/components/VehiculoSalida'
import Trm from '@/components/Trm'
import VehiculosTabla from '@/components/VehiculosTabla'
import WebService from '@/helpers/WebService'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'


export default {

  name: 'Estacionamiento',
  components: {
    NavEstacionamiento,
    VehiculoIngreso,
    VehiculoSalida,
    Trm,
    VehiculosTabla,
    WebService
  },

  created () {
    this.info = WebService.get('http://localhost:8080/estacionamiento/estacionamiento/');
  },

  methods: {
    actualizarListaVehiculos() {
      this.actualizarTabla = true,
      console.log("actualizarListaVehiculos")
    },
    vehiculosTablaActualizada() {
      this.actualizarTabla = false
    },
    vehiculoSeleccionadoTabla(seleccionadoEnTabla) {
      this.seleccionadoEnTabla = seleccionadoEnTabla,
      console.log("Vehiculo"),
      console.log("vehiculoSeleccionado", seleccionadoEnTabla.tipo)
    },
    errorMensaje(mensajeError){
//      alert(mensajeError),
      this.modalMostrar = true,
      this.mensajeError = mensajeError
    }
  },

  data () {
    return {
      users: '',
      seleccionadoEnTabla: {},
      actualizarTabla: false,
      mensajeError: null,
      modalMostrar: false,
      msg: 'Bienvenido a Ceiba Estacionamiento(juan.giraldo)',
      info: null
    }
  }
}
</script>
