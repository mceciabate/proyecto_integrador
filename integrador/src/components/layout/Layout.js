import React from 'react';
import Header from '../Header';
import Footer from '../Footer'
import { LayoutC } from '../../styles/Extras'

const Layout = ({ children, isLogged, setIsLogged }) => {
  return (
    <LayoutC>
      {<Header isLogged={isLogged} setIsLogged={setIsLogged} />}
      {children}
      {<Footer />}
    </LayoutC>
  )
}

export default Layout;