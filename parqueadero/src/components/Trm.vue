<template>

<div>

  <div class="jumbotron">
    <h1 class="display-4">{{msg}}</h1>
    <p class="lead">{{trm | aDinero }}</p>
  </div>



</div>
</template>


<script>
import axios from 'axios'

export default {
  name: 'Trm',
  data () {
    return {
      msg: 'TRM del día',
      trm:0
    }
  },

  filters: {
    aDinero: function (value) {
      if (!value) return ''
      var formatter = new Intl.NumberFormat('en-US', {
          style: 'currency',
          currency: 'COP',
          minimumFractionDigits: 0
      });
      return formatter.format(value);
    }
  },

  mounted () {

    {
      axios.get( 'http://app.docm.co/prod/Dmservices/Utilities.svc/GetTRM', { crossdomain: true })
      .then((response) => {
        this.trm= response.data
        // Emite evento a parents informando que se realizo un ingreso de vehiculo
        this.$emit('oningresovehiculo');
      })
      .catch((error) => {
        this.$emit('onerrormensaje', error.response.data)
      })
    }
  },
}
</script>
