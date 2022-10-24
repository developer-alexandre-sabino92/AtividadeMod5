import { useState } from 'react';
import Card from '../components/card';
import FormGroup from '../components/form-group';


function Login() {

    const [email, setEmail] = useState();
    const [senha, setSenha] = useState();

    const logar = (e) => {
        e.preventDefault();
        console.log(`Email: ${email}`)
        console.log(`Senha: ${senha}`)

    }


    return (
        <div className="row">
            <div className="col-md-6" style={{ position: 'relative', left: '300px' }}>
                <Card titulo="Login">
                    <form>
                        <fieldset>
                            <FormGroup htmlFor="InputEmail1" label="Email: *">
                                <input
                                    value={email}
                                    type="email" className="form-control"
                                    name='email'
                                    Id='InputEmail1'
                                    aria-describedby='emailHelp'
                                    placeholder='Digite seu email'
                                    onChange={e => setEmail(e.target.value)}
                                     />
                            </FormGroup>
                            <FormGroup htmlFor="InputSenha1" label="Senha: *">
                                <input
                                    value={senha}
                                    type="senha" className="form-control"
                                    name='senha'
                                    Id='InputSenha1'
                                    aria-describedby='senhaHelp'
                                    placeholder='Digite sua senha' 
                                    onChange={e => setSenha(e.target.value)}
                                    />
                            </FormGroup>
                            <button className='btn btn-success' onClick={logar}>Entrar</button>
                            <button className="btn btn-danger">Cadastrar</button>
                        </fieldset>

                    </form>
                </Card>

            </div>
        </div>


    )


}

export default Login;