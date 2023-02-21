from django.shortcuts import render,redirect
from django.views.generic import CreateView
from django.contrib.auth.forms import AuthenticationForm
from django.contrib.auth import login,logout,authenticate
from django.contrib import messages
from django.contrib.auth.models import User
from .forms import RegistroForm
from django.template.loader import render_to_string
from django.utils.html import strip_tags
from django.core.mail import send_mail
from django.conf import settings

# Create your views here.

class VistaRegistro(CreateView):
    model= User
    template_name='registro/registro.html'
    
    def get(self,request):
        form=RegistroForm()
        return render(request,'registro/registro.html',{'form':form})
    
    def post(self,request):    
        form=RegistroForm(request.POST)
        if form.is_valid():
            usuario=form.save()
            login(request,usuario)
            email=request.POST['email']
            user=request.POST['username']
            name=request.POST['first_name']
            asunto='Gracias por registrarse!!!'
            from_email=settings.EMAIL_HOST_USER
            to= email
            template=render_to_string('email/send_mail.html',{
                'username':user,
                'name':name
            })
            mensaje_texto=strip_tags(template)
            send_mail(asunto,mensaje_texto,from_email,[to],html_message=template)        
            return redirect('home')
        else:
            for msg in form.error_messages:
                messages.error(request,form.error_messages[msg])
            return render(request,'registro/registro.html',{'form':form})
        
def cerrar_sesion(request):
    logout(request)
    return redirect('home')     

def log_in(request):
    if request.method=='POST':
        form=AuthenticationForm(request,data=request.POST)
        if form.is_valid():
            nombre_usuario=form.cleaned_data.get('username')
            contra=form.cleaned_data.get('password')
            usuario=authenticate(username=nombre_usuario,password=contra)
            if usuario is not None:
                login(request,usuario)
                return redirect('home')
            else:
                messages.error(request,'Usuario o contraseña no válido')
        else:
            messages.error(request,'Usuario o contraseña no válido')        
    form=AuthenticationForm()
    return render(request,'login/login.html',{'form':form})
    
    