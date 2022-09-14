import React from 'react'
import { SuccessDiv, SuccessContainer } from './ReserveStyles'
import Tic from '../../assets/Vector.png'

const ReserveSuccess = () => {
  return (
    <SuccessContainer>
      <SuccessDiv>
        <img src={Tic} alt='tic'/>
        <h4>¡Muchas gracias!</h4>
        <p>Su reserva se ha relizado con exito</p>
        <button>Ok</button>
      </SuccessDiv>
    </SuccessContainer>
  )
}

export default ReserveSuccess