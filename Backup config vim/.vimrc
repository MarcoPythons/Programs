  "Initial Set up
set number
set mouse =a
set numberwidth=1
set clipboard=unnamed
syntax enable
set showcmd
set ruler
set encoding=utf-8
set showmatch
set sw=2
set laststatus =2
set noshowmode
set smartindent
set nowrap
set incsearch
set t_Co=256
"End Initial Set up

"Plugin Manager
call plug#begin('$HOME/.vim/plugged')

"plugins"
Plug 'franbach/miramare'
Plug 'easymotion/vim-easymotion' 
Plug 'scrooloose/nerdtree'
Plug 'artanikin/vim-synthwave84'
Plug 'arzg/vim-colors-xcode'
Plug 'bluz71/vim-nightfly-guicolors'
Plug 'neoclide/coc.nvim', {'branch': 'release'}
Plug 'rakr/vim-one'
Plug 'vim-airline/vim-airline'
Plug 'vim-airline/vim-airline-themes'
Plug 'powerline/fonts'
Plug 'sainnhe/sonokai'
Plug 'prettier/vim-prettier', { 'do': 'yarn install' }
Plug 'yuezk/vim-js'

"end plugins"




call plug#end()
"End Plugin Manager

"Keys Maps
let mapleader=" " 
nmap <Leader>s <Plug>(easymotion-s2)
nmap <Leader>nt :NERDTreeFind<CR>
nmap <silent> gd <Plug>(coc-definition)
nmap <silent> gy <Plug>(coc-type-definition)
nmap <silent> gi <Plug>(coc-implementation)
nmap <silent> gr <Plug>(coc-references)
nmap <Leader>w :w <CR>
nmap <Leader>q :q <CR>
nmap <Leader>e :e .vimrc<cr>
nmap <Leader>py <Plug>(Prettier)
nmap <Leader>pl :PlugInstall<CR>
noremap <Leader>gs :CocSearch 
nnoremap <silent> ba  :bprevious<cr>
nnoremap <silent> bb :bnext<cr>
nnoremap <silent> BA :bfirst<cr>
nnoremap <silent> BB :blast<cr>
nnoremap <silent> VS :vsplit<cr> 
nnoremap <silent> cb :bd<cr>


if &filetype == "javascript" || &filetype == "python"
   inoremap <c-space> <C-x><C-u>
 else
   inoremap <silent><expr> <c-space> coc#refresh()

 endif
"End Keys Maps

"COLORSCHEME
if has('termguicolors')
  set termguicolors
endif
let g:sonokai_style = 'andromeda'
let g:sonokai_enable_italic = 1
let g:sonokai_disable_italic_comment = 1
let g:sonokai_cursor = 'red'
colorscheme sonokai
"End COLORSCHEME

"airline setup
let g:airline_theme='kalisi'
let g:airline_section_t = 'BN: %{bufnr("%")}'
let g:airline_powerline_fonts = 1 
let g:airline#extensions#tabline#enabled = 1
let g:airline#extensions#tabline#left_sep = ' '
let g:airline#extensions#tabline#left_alt_sep ='▸▸' 
let g:airline_left_sep = '»'
let g:airline_left_sep = '»»'
let g:airline_right_sep = '«'
let g:airline_right_sep = '««'
let g:airline#extensions#tabline#formatter = 'unique_tail'
let g:airline#extensions#coc#enabled = 1
function! AccentDemo()
  let keys = ['T','U','P','U','T','A','M','A', 'D','R','E']
  for k in keys
    call airline#parts#define_text(k, k)
  endfor
  call airline#parts#define_accent('T', 'red')
  call airline#parts#define_accent('U', 'purple')
  call airline#parts#define_accent('P', 'blue')
  call airline#parts#define_accent('U', 'bold')
  call airline#parts#define_accent('T', 'orange')
  call airline#parts#define_accent('A', 'purple')
  call airline#parts#define_accent('M', 'bold')
  call airline#parts#define_accent('A', 'red')
  call airline#parts#define_accent('D', 'purple')
  call airline#parts#define_accent('R', 'green')
  call airline#parts#define_accent('E', 'blue')
  let g:airline_section_a = airline#section#create(keys)
endfunction
autocmd VimEnter * call AccentDemo()
"End airline setup

"Prettier setup
let g:prettier#config#single_quote = 'true'
let g:prettier#config#trailing_comma = 'all'

"end Prettier setup

"kite setup
let g:kite_supported_languages = ['javascript', 'python']
autocmd FileType python let b:coc_suggest_disable = 1
autocmd FileType javascript let b:coc_suggest_disable = 1
autocmd FileType scss setl iskeyword+=@-@
" end kite setup



"nerd tree configuration
  
autocmd StdinReadPre * let s:std_in=1
"autocmd VimEnter * if argc() == 0 && !exists("s:std_in") | NERDTree | endif 
autocmd vimenter * NERDTree $Programming
let g:NERDTreeDirArrowExpandable = '▸'
let g:NERDTreeDirArrowCollapsible = '▾'
let NERDTreeDirArrows=1
let NERDTreeShowLineNumbers=1
"end nerd tree configuration
