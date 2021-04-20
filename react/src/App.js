import logo from './logo.svg';
import 'App.css';
import {Route} from 'react-router';
import {ArticleList, ArticleWrite, ArticleDetail, ArticleUpdate} from 'article/index' 
import {NewsBoard, SeoulCCTV} from 'board/index'
import {SignUp, LoginForm, UserDetail} from 'user/index'
import {Home, Head, Body, Footer} from 'common/index'
import {Counter, ReduxCounter, RTKCounter} from 'counter/index'

const App = () => {
    return (
        <div className="App">
            <Route exact="exact" path='/' component={Home}></Route>

            <Route exact="exact" path='/board/seoul-cctv' component={SeoulCCTV}></Route>
            <Route exact="exact" path='/counter/counter' component={Counter}></Route>
            <Route exact="exact" path='/counter/redux-counter' component={ReduxCounter}></Route>
            <Route exact="exact" path='/counter/rtk-counter' component={RTKCounter}></Route>
            <Route exact="exact" path="/board/news" component={NewsBoard}></Route>
            <Route exact="exact" path='/article/article-detail' component={ArticleDetail}></Route>
            <Route exact="exact" path='/article/article-list' component={ArticleList}></Route>
            <Route exact="exact" path='/article/article-update' component={ArticleUpdate}></Route>
            <Route exact="exact" path='/article/article-write' component={ArticleWrite}></Route>

            <Route exact="exact" path='/user/login-form' component={LoginForm}></Route>
            <Route exact="exact" path='/user/sign-up' component={SignUp}></Route>
            <Route exact="exact" path='/user/user-detail' component={UserDetail}></Route>
            

            <Route exact="exact" path='/common/body' component={Body}></Route>
            <Route exact="exact" path='/common/footer' component={Footer}></Route>
            <Route exact="exact" path='/common/head' component={Head}></Route>
        
        </div>
    );
}

export default App;
