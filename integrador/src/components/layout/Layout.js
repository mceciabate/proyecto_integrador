import React from 'react';
import HeaderDesktop from '../HeaderDesktop';
import HeaderMobile from '../HeaderMobile';
import Footer from '../Footer'
import { LayoutC } from '../../styles/Extras'

const Layout = ({ children, isLogged, setIsLogged }) => {
  return (
    <LayoutC>
      {<HeaderDesktop isLogged={isLogged} setIsLogged={setIsLogged} />}
      {<HeaderMobile isLogged={isLogged} setIsLogged={setIsLogged} />}
      {children}
      {<Footer />}
    </LayoutC>
  )
}

export default Layout;